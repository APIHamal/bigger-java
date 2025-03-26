package com.lizhengpeng.bigger.java.impl;

import com.lizhengpeng.bigger.java.grpc.GrpcServer;
import io.grpc.*;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.stub.ServerCalls;
import io.grpc.stub.StreamObserver;
import io.grpc.util.MutableHandlerRegistry;

public class FallbackServer {

    // 定义服务名称
    private static final String SERVICE_NAME = "FallbackService";

    public static void main(String[] args) throws Exception{
        MutableHandlerRegistry registry = new MutableHandlerRegistry();
        // 一元调用方法描述符
        MethodDescriptor<GrpcServer.Payload, GrpcServer.Payload> unaryMethod = MethodDescriptor.<GrpcServer.Payload, GrpcServer.Payload>newBuilder()
                .setType(MethodDescriptor.MethodType.UNARY)
                .setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "unaryEcho"))
                .setRequestMarshaller(ProtoUtils.marshaller(GrpcServer.Payload.getDefaultInstance()))
                .setResponseMarshaller(ProtoUtils.marshaller(GrpcServer.Payload.getDefaultInstance()))
                .build();
        // 定义一元调用处理逻辑
        ServerCallHandler<GrpcServer.Payload, GrpcServer.Payload> unaryCall = ServerCalls.asyncUnaryCall((payload, streamObserver) -> {
            System.out.println(payload);
            streamObserver.onNext(payload);
            streamObserver.onCompleted();
        });

        // 双向流方法描述符
        MethodDescriptor<GrpcServer.Payload, GrpcServer.Payload> bidiMethod = MethodDescriptor.<GrpcServer.Payload, GrpcServer.Payload>newBuilder()
                .setType(MethodDescriptor.MethodType.BIDI_STREAMING)
                .setFullMethodName(MethodDescriptor.generateFullMethodName(SERVICE_NAME, "doubleStreamEcho"))
                .setRequestMarshaller(ProtoUtils.marshaller(GrpcServer.Payload.getDefaultInstance()))
                .setResponseMarshaller(ProtoUtils.marshaller(GrpcServer.Payload.getDefaultInstance()))
                .build();

        // 双向流的处理逻辑
        ServerCallHandler<GrpcServer.Payload, GrpcServer.Payload> bidiServerCall = ServerCalls.asyncBidiStreamingCall(new ServerCalls.BidiStreamingMethod<GrpcServer.Payload, GrpcServer.Payload>() {
            @Override
            public StreamObserver<GrpcServer.Payload> invoke(StreamObserver<GrpcServer.Payload> streamObserver) {
                return null;
            }
        });

        // 构建服务定义
        // 如果有多个同名的ServerServiceDefinition
        // 后者会【覆盖】前面的服务定义
        ServerServiceDefinition serviceDefinition = ServerServiceDefinition.builder(SERVICE_NAME)
                .addMethod(unaryMethod, unaryCall) // 绑定方法描述符和处理逻辑(一元调用)
                .addMethod(bidiMethod, bidiServerCall) // 绑定方法描述符和处理逻辑(双向调用)
                .build();
        // 注册服务
        registry.addService(serviceDefinition);

        Server server = ServerBuilder
                .forPort(8080)
                .intercept(new FallbackInterceptor())
                .fallbackHandlerRegistry(registry)
                .build();
        server.start();
        System.out.println("Grpc Server started, listening on " + server.getPort());
        server.awaitTermination();
    }
}
