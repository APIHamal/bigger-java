package com.lizhengpeng.bigger.java;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.lizhengpeng.bigger.java.ContextHolder.TRACE_ID;

@Component
@Order(-10)
public class TraceIdFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String traceId = exchange.getRequest().getHeaders().getFirst(TRACE_ID);
        if (StringUtils.isBlank(traceId)) {
            traceId = UUID.randomUUID().toString();
        }
//        exchange.getRequest().getHeaders().set(TRACE_ID, traceId);
        try {
            ContextHolder.setTraceId(traceId);
            return chain.filter(exchange);
        } finally {
            ContextHolder.remove();
        }
    }

}
