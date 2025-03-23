package com.lizhengpeng.bigger.java;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class SampleController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private ProviderFeign providerFeign;

    @GetMapping("/test-loader-balancer")
    public void testLoaderBalancer() {
        loadBalancerClient.choose("provider-sample");
    }

    @GetMapping("/hello")
    public String callProvider() {
        return providerFeign.callHello();
    }

}
