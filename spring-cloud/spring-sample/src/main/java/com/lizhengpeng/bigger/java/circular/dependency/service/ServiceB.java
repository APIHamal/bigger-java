package com.lizhengpeng.bigger.java.circular.dependency.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ServiceB {

    @Resource
    private ServiceA serviceA;

    public void say() {
        System.out.println(serviceA + "called ,this is serviceB");
    }

}
