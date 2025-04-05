package com.lizhengpeng.bigger.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Component
public class RequestLogFilter extends AbstractGatewayFilterFactory<RequestLogFilter.RequestLogConfig> {

    @Resource
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    public RequestLogFilter() {
        super(RequestLogFilter.RequestLogConfig.class);
    }

    @Override
    public GatewayFilter apply(RequestLogConfig config) {
        return (exchange, chain) -> {
            if (config.isOpen()) {
                String url = exchange.getRequest().getURI().getPath();
                System.out.println("网关过滤器拦截到" + url);
                return reactiveRedisTemplate.opsForValue()
                        .set(url, url)
                        .then(chain.filter(exchange));
            }
            return chain.filter(exchange).then(Mono.fromRunnable(() -> System.out.println("网关过滤器检测到请求已经完成")));
        };
    }


    @Data
    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestLogConfig {

        private boolean open = false;

    }
}
