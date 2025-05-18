package com.lizhengpeng.bigger.java;

import net.bytebuddy.agent.VirtualMachine;

import java.io.IOException;

/**
 * 动态插装示例代码
 * @author lzp
 * @since 2025-05-18
 */
public class DynamicAttachSample {
    public static void main(String[] args) throws IOException {
        // 目标JVM进程ID
        String pid = "26972";
        // agent代码路径
        String agentJar = "C:\\Users\\zheng\\IdeaProjects\\bigger-java\\spring-cloud\\instrumentation-sample\\target\\instrumentation-sample-1.0.jar";
        VirtualMachine vm = VirtualMachine.ForHotSpot.attach(pid);
        vm.loadAgent(agentJar);
        vm.detach();
    }
}
