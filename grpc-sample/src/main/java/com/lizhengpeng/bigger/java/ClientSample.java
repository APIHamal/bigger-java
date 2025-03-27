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

        EchoServiceGrpc.EchoServiceStub echoServiceStub = EchoServiceGrpc.newStub(channel);
        StreamObserver<GrpcServer.GrpcRequest> requestStreamObserver = echoServiceStub.streamEcho(new StreamObserver<GrpcServer.GrpcRequest>() {
            @Override
            public void onNext(GrpcServer.GrpcRequest grpcRequest) {
                System.out.println("接收到服务端消息" + grpcRequest.toString());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("服务端消息推送完成");
            }
        });
        requestStreamObserver.onNext(GrpcServer.GrpcRequest.newBuilder()
                .setRequestId("request-id-1")
                .build());
        requestStreamObserver.onNext(GrpcServer.GrpcRequest.newBuilder()
                .setRequestId("request-id-2")
                .build());
        requestStreamObserver.onCompleted();

        Thread.sleep(1000 * 5);

    }
}
