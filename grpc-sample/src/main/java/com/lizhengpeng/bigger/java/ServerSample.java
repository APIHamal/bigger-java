package com.lizhengpeng.bigger.java;

import com.lizhengpeng.bigger.java.impl.EchoServiceImpl;
import com.lizhengpeng.bigger.java.impl.PrintServiceImpl;
import io.grpc.*;

public class ServerSample {
    public static void main(String[] args) throws Exception {
        Server echoServer = ServerBuilder.forPort(8888)
                .addService(new EchoServiceImpl())
                .addService(new PrintServiceImpl())
                // 添加channel属性
                .addTransportFilter(new ServerTransportFilter() {
                    @Override
                    public Attributes transportReady(Attributes transportAttrs) {
                        System.out.println("new client received" + transportAttrs.get(Grpc.TRANSPORT_ATTR_REMOTE_ADDR));
                        return super.transportReady(transportAttrs);
                    }
                })
                .build();
        echoServer.start();
        System.out.println("Server started...");
        echoServer.awaitTermination();
    }
}
