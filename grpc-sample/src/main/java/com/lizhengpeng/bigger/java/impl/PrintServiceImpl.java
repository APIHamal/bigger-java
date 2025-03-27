package com.lizhengpeng.bigger.java.impl;

import com.lizhengpeng.bigger.java.grpc.GrpcServer;
import com.lizhengpeng.bigger.java.grpc.PrintServiceGrpc;
import io.grpc.stub.StreamObserver;

public class PrintServiceImpl extends PrintServiceGrpc.PrintServiceImplBase {
    @Override
    public void print(GrpcServer.GrpcRequest request, StreamObserver<GrpcServer.GrpcRequest> responseObserver) {
        responseObserver.onNext(request);
        responseObserver.onCompleted();
    }
}
