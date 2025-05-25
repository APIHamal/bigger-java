package com.lizhengpeng.bigger.java.aop.base;

import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloService {

    public void sayHello() {
        System.out.println("hello aop!");
    }

}
