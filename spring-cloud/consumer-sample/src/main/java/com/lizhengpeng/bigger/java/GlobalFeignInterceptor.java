package com.lizhengpeng.bigger.java;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class GlobalFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        template.header(ContextHolder.TRACE_ID, ContextHolder.getTraceId());
    }
}
