package com.lizhengpeng.bigger.java.impl;

import com.lizhengpeng.bigger.java.grpc.FallbackServiceGrpc;
import com.lizhengpeng.bigger.java.grpc.GrpcServer;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class FallbackClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("127.0.0.1:8080")
                .usePlaintext()
                .build();
        FallbackServiceGrpc.FallbackServiceBlockingStub stub = FallbackServiceGrpc.newBlockingStub(channel);
        GrpcServer.Payload payload = stub.unaryEcho(GrpcServer.Payload.newBuilder()
                .setType("hello world")
                .setResponse("test fallback")
                .build());
        System.out.println(payload);
        channel.shutdown();

    }
}
