package com.lizhengpeng.bigger.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class GlobalExceptionHandler implements ErrorWebExceptionHandler {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        log.error("Gateway exception handler", ex);
        HttpStatus serverError = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ex instanceof ResponseStatusException) {
            serverError = ((ResponseStatusException) ex).getStatus();
        }
        if (exchange.getResponse().isCommitted()) {
            return Mono.empty();
        }
        // 返回前端响应
        DataBufferFactory bufferFactory = exchange.getResponse().bufferFactory();
        exchange.getResponse().setStatusCode(serverError);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
        // 返回响应
        String reason = "{\"code\":500, \"reason\":\"Bad Gateway\"}";
        return exchange.getResponse().writeWith(Mono.just(bufferFactory.wrap(reason.getBytes(StandardCharsets.UTF_8))));
    }
}
