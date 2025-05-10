package com.lizhengpeng.bigger.java;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义HandlerMethodArgumentResolver参数处理器
 * @author lzp
 * @since 2025-05-10
 */
public class EasyStreamHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(EasyStream.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 获取request与response对象
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        Object result = request.getAttribute(EasyStream.EASY_STREAM_RESULT_ATTRIBUTE);
        if (result instanceof Throwable) {
            mavContainer.setRequestHandled(true);
            throw new RuntimeException("nested exception", (Throwable) result);
        }
        HttpServletResponse response = (HttpServletResponse) webRequest.getNativeResponse();
        // 流对象
        EasyStream easyStream = new EasyStream(request, response);
        mavContainer.setRequestHandled(true);
        return easyStream;
    }
}
