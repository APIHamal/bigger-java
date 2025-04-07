package com.lizhengpeng.bigger.java;

import lombok.Data;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;

@Component
public class IpRateLimiter extends AbstractGatewayFilterFactory<IpRateLimiter.Config> {

    private String RATE_LIMITER_SCRIPT;

    @Resource
    private ReactiveRedisTemplate<String, Object> reactiveRedisTemplate;

    public IpRateLimiter() {
        super(IpRateLimiter.Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        try {
            RATE_LIMITER_SCRIPT = IOUtils.toString(new ClassPathResource(config.getScript()).getURL());
        } catch (IOException e) {
            throw new GatewayException("load rate limiter script exception", e);
        }
        return (exchange, chain) -> {
            // 获取当前客户端的IP地址
            String remoteIp = exchange.getRequest().getRemoteAddress()
                    .getAddress()
                    .toString();
            if (StringUtils.isBlank(remoteIp)) {
                return chain.filter(exchange);
            }
            // 创建 Redis 脚本对象
            DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>(
                    RATE_LIMITER_SCRIPT,
                    Boolean.class
            );
            // 执行 Lua 脚本
            return reactiveRedisTemplate.execute(
                            redisScript,
                            Collections.singletonList(remoteIp),
                            Arrays.asList(5, 10) // 参数示例：capacity=5, rate=10
                    )
                    .single() // 确保返回单个结果（Flux -> Mono）
                    .flatMap(allowed -> {
                        if (Boolean.TRUE.equals(allowed)) {
                            return chain.filter(exchange); // 允许请求
                        } else {
                            ServerHttpResponse response = exchange.getResponse();
                            if (response.isCommitted()) {
                                return Mono.empty();
                            }

                            String jsonBody = "{\"code\": 429, \"message\": \"请求过于频繁\"}";
                            response.setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
                            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);

                            DataBuffer buffer = response.bufferFactory().wrap(jsonBody.getBytes(StandardCharsets.UTF_8));
                            return response.writeWith(Mono.just(buffer)); // 正确返回 Mono<Void>
                        }
                    });
        };
    }

    @Data
    public static class Config {

        private String script;

    }

}
