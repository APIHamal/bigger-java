package com.lizhengpeng.bigger.java;

import java.util.ArrayList;
import java.util.List;

public class OOMSample {

    static class OOM {
        private final byte[] content = new byte[1024 * 1024 * 1]; // 8MB
    }

    public void test() {
        List<OOM> oomList = new ArrayList<>();
        for (int index = 0; index < 100; index++) {
            oomList.add(new OOM());
        }

    }

    public static void printStr() {
        System.out.println("测试数据");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                printStr();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        });
        thread.setDaemon(false);
        thread.start();

        new OOMSample().test();
    }
}
