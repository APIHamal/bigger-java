package com.lizhengpeng.bigger.java;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "provider-sample")
public interface ProviderFeign {

    @GetMapping("/hello")
    String callHello();

}
