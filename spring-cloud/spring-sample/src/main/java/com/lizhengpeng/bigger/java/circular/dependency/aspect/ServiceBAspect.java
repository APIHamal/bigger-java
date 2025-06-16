package com.lizhengpeng.bigger.java.circular.dependency.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceBAspect {

    @Pointcut("execution(* com.lizhengpeng.bigger.java.circular.dependency.service.ServiceB.*(..))")
    public void aspect() {}

    @Around("aspect()")
    public Object aspectExecute(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("执行切面方法");
        return joinPoint.proceed();
    }

}
