package com.lizhengpeng.bigger.java;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

public class MethodStatAgent {

    public static void premain(String args, Instrumentation inst) {
        new AgentBuilder.Default()
                // 关键配置：允许重新转换已加载的类
                .disableClassFormatChanges()
                .with(AgentBuilder.RedefinitionStrategy.RETRANSFORMATION)
                .with(AgentBuilder.InitializationStrategy.NoOp.INSTANCE)
                .with(AgentBuilder.TypeStrategy.Default.REDEFINE)

                // 类匹配规则：排除所有 JDK 内部类和代理类
                .type(ElementMatchers.not(ElementMatchers.nameStartsWith("java."))
                        .and(ElementMatchers.not(ElementMatchers.nameStartsWith("sun.")))
                        .and(ElementMatchers.not(ElementMatchers.nameStartsWith("jdk.")))
                        .and(ElementMatchers.not(ElementMatchers.nameStartsWith("net.bytebuddy.")))
                )

                // 方法拦截逻辑（修复 Lambda 参数签名）
                .transform(new AgentBuilder.Transformer() {
                    @Override
                    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
                        return builder.visit(
                                Advice.to(MethodAdvice.class)
                                        .on(ElementMatchers.isMethod()
                                                .and(ElementMatchers.not(ElementMatchers.isConstructor()))
                                        )
                        );
                    }
                })

                // 安装到 Instrumentation
                .installOn(inst);
    }

    public static void agentmain(String args, Instrumentation inst) {
        premain(args, inst);
    }

    // 方法拦截逻辑实现
    public static class MethodAdvice {
        @Advice.OnMethodEnter
        static long enter() {
            System.out.println("方法进入" + Thread.currentThread().getName());
            return System.currentTimeMillis();
        }

        @Advice.OnMethodExit(onThrowable = Throwable.class)
        static void exit(
                @Advice.Enter long start,
                @Advice.Origin String method,
                @Advice.Thrown Throwable error) {
            long duration = System.currentTimeMillis() - start;
            System.out.printf("执行时间 " + duration);
            if (error != null) {
                System.out.println("发生了异常调用" + error);
            }
        }
    }
}