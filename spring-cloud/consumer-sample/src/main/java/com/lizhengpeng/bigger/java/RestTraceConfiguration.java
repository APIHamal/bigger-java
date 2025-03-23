package com.lizhengpeng.bigger.java;

import feign.RequestInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor;
import org.springframework.cloud.client.loadbalancer.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.util.List;

@Configuration
public class RestTraceConfiguration {

    @Bean
    public RequestInterceptor feignTrace() {
        return new GlobalFeignInterceptor();
    }

    @Bean
    public RestTemplateCustomizer restTemplateTrace(LoadBalancerInterceptor loadBalancerInterceptor) {
        RestTemplateCustomizer restTemplateCustomizer = restTemplate -> {
            List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
            interceptors.add((request, body, execution) -> {
                request.getHeaders().add(ContextHolder.TRACE_ID, ContextHolder.getTraceId());
                return execution.execute(request, body);
            });
            interceptors.add(loadBalancerInterceptor);
        };
        return restTemplateCustomizer;
    }

}
