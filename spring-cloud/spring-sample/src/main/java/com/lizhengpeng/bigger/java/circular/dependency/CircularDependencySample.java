package com.lizhengpeng.bigger.java.circular.dependency;

import com.lizhengpeng.bigger.java.circular.dependency.service.ServiceA;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.lizhengpeng.bigger.java.circular.dependency.**"})
@EnableAspectJAutoProxy
public class CircularDependencySample {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CircularDependencySample.class);
        ServiceA bean = context.getBean(ServiceA.class);
        bean.say();
    }
}