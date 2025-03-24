package com.lizhengpeng.bigger.java;

import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class LogFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse originalResponse = exchange.getResponse();
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();

        ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                // 提前返回错误通知前端
                String contentType = originalResponse.getHeaders().getFirst("content-type");
                if (contentType.contains("json")) {
                    originalResponse.setStatusCode(HttpStatus.BAD_GATEWAY);
                    return super.writeWith(Flux.just(bufferFactory.wrap("error".getBytes(StandardCharsets.UTF_8))));
                }

                if (body instanceof Flux) {
                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
                    return super.writeWith(fluxBody.buffer().map(dataBuffers -> {
                        // 合并所有缓冲区
                        DataBufferFactory df = new DefaultDataBufferFactory();
                        DataBuffer join = df.join(dataBuffers);
                        byte[] content = new byte[join.readableByteCount()];
                        join.read(content);
                        // 释放缓冲区
                        DataBufferUtils.release(join);
                        // 转换为字符串
                        String responseBody = new String(content, StandardCharsets.UTF_8);
                        // 记录日志（实际应用中建议使用日志框架）
                        System.out.println("Response Body: " + responseBody);
                        // 返回原始数据
                        return bufferFactory.wrap(content);
                    }));
                }
                // 非Flux类型直接返回
                return super.writeWith(body);
            }
        };

        // 替换响应并继续处理
        return chain.filter(exchange.mutate().response(decoratedResponse).build());
    }

    @Override
    public int getOrder() {
        return -2;
    }
}
