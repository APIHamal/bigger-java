package com.lizhengpeng.bigger.java.aop.base;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {

    @Pointcut("execution(* com.lizhengpeng.bigger.java.aop.base.HelloService.*(..))")
    public void aspect() {
    }

    @Around("aspect()")
    public void serviceAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("拦截到[HelloService]的方法执行");
        joinPoint.proceed();
    }

}
