package com.lizhengpeng.bigger.java;

import com.lizhengpeng.bigger.java.grpc.GrpcServer;
import com.lizhengpeng.bigger.java.impl.EchoServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.util.UUID;

public class GrpcClientSample {
    public static void main(String[] args) throws Exception {
        Server echoServer = ServerBuilder.forPort(8888)
                .addService(new EchoServiceImpl())
                .build();
        echoServer.start();
        System.out.println("Server started...");
        echoServer.awaitTermination();

    }
}
