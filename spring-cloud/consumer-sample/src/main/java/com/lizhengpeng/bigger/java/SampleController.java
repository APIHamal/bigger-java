package com.lizhengpeng.bigger.java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class SampleController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/hello")
    public String callProvider() {
        return restTemplate.getForObject("http://provider-sample:8081/hello", String.class);
    }

}
