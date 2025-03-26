package com.lizhengpeng.bigger.java.impl;

import com.lizhengpeng.bigger.java.grpc.EchoServiceGrpc;
import com.lizhengpeng.bigger.java.grpc.GrpcServer;
import io.grpc.stub.StreamObserver;

public class EchoServiceImpl extends EchoServiceGrpc.EchoServiceImplBase {
    @Override
    public void echo(GrpcServer.GrpcRequest request, StreamObserver<GrpcServer.GrpcRequest> responseObserver) {
        responseObserver.onNext(GrpcServer.GrpcRequest.newBuilder()
                        .setRequestId("Echo Service Response")
                        .setRequestIndex(1)
                .build());
        responseObserver.onCompleted();
    }
}
