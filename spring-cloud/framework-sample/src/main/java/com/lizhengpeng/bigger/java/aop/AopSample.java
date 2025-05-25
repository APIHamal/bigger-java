package com.lizhengpeng.bigger.java.aop;

import com.lizhengpeng.bigger.java.aop.base.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.lizhengpeng.bigger.java.aop.base")
@EnableAspectJAutoProxy
public class AopSample {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopSample.class);
        HelloService service = context.getBean("helloService", HelloService.class);
        service.sayHello();
    }

}
