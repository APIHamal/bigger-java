package com.lizhengpeng.bigger.java.circular.dependency.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServiceA {

    @Resource
    private ServiceB serviceB;

    public void say() {
        serviceB.say();
    }

}
