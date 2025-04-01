package com.lizhengpeng.bigger.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@RefreshScope
public class HelloComponent {

    @Value("${hello}")
    private String hello;

    public String getHello() {
        return hello;
    }

    public HelloComponent setHello(String hello) {
        this.hello = hello;
        return this;
    }

    @PostConstruct
    public void init() {
        System.out.println("HelloComponent 组件被初始化");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("HelloComponent 组件被销毁");
    }
}
