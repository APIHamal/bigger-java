package com.lizhengpeng.bigger.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class ProviderApplication {

    @GetMapping("/hello")
    public String welcome(HttpServletRequest request) {
        String header = request.getHeader("X-TRACE-ID");
        return "welcome, baby! TraceId:" + header;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
