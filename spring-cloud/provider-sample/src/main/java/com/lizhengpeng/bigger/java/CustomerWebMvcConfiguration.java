package com.lizhengpeng.bigger.java;

import org.springframework.stereotype.Component;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 自定义springMvc的ReturnValueHandler
 * 用来实现类似【服务端流】的功能
 * @author lzp
 * @since 2025-05-10
 */
@Component
public class CustomerWebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        handlers.add(new EasyDeferredReturnValueHandler());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new EasyStreamHandlerMethodArgumentResolver());
    }
}
