package com.lizhengpeng.bigger.java;

import com.lizhengpeng.bigger.java.grpc.EchoServiceGrpc;
import com.lizhengpeng.bigger.java.grpc.GrpcServer;
import com.lizhengpeng.bigger.java.grpc.PrintServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class ClientSample {
    public static void main(String[] args) throws InterruptedException {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8888)
                .usePlaintext()
                .build();
        GrpcServer.GrpcRequest request = GrpcServer.GrpcRequest
                .newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setRequestIndex(1)
                .build();

        EchoServiceGrpc.EchoServiceBlockingStub echoServiceBlockingStub = EchoServiceGrpc.newBlockingStub(channel);
        echoServiceBlockingStub.echo(request);
        System.out.println("echoServiceBlockingStub channel " + echoServiceBlockingStub.getChannel());

        PrintServiceGrpc.PrintServiceBlockingStub printServiceBlockingStub = PrintServiceGrpc.newBlockingStub(channel);
        printServiceBlockingStub.print(request);
        System.out.println("printServiceBlockingStub channel " + printServiceBlockingStub.getChannel());

        Thread.sleep(1000 * 5);

    }
}
