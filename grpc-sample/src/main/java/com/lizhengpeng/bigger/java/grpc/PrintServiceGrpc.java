package com.lizhengpeng.bigger.java.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.0)",
    comments = "Source: inteceptor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PrintServiceGrpc {

  private PrintServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "PrintService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> getPrintMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "print",
      requestType = com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.class,
      responseType = com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> getPrintMethod() {
    io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest, com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> getPrintMethod;
    if ((getPrintMethod = PrintServiceGrpc.getPrintMethod) == null) {
      synchronized (PrintServiceGrpc.class) {
        if ((getPrintMethod = PrintServiceGrpc.getPrintMethod) == null) {
          PrintServiceGrpc.getPrintMethod = getPrintMethod =
              io.grpc.MethodDescriptor.<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest, com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "print"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.getDefaultInstance()))
              .setSchemaDescriptor(new PrintServiceMethodDescriptorSupplier("print"))
              .build();
        }
      }
    }
    return getPrintMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PrintServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrintServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrintServiceStub>() {
        @java.lang.Override
        public PrintServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrintServiceStub(channel, callOptions);
        }
      };
    return PrintServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PrintServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrintServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrintServiceBlockingStub>() {
        @java.lang.Override
        public PrintServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrintServiceBlockingStub(channel, callOptions);
        }
      };
    return PrintServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PrintServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PrintServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PrintServiceFutureStub>() {
        @java.lang.Override
        public PrintServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PrintServiceFutureStub(channel, callOptions);
        }
      };
    return PrintServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void print(com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest request,
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getPrintMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PrintService.
   */
  public static abstract class PrintServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PrintServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PrintService.
   */
  public static final class PrintServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PrintServiceStub> {
    private PrintServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrintServiceStub(channel, callOptions);
    }

    /**
     */
    public void print(com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest request,
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPrintMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PrintService.
   */
  public static final class PrintServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PrintServiceBlockingStub> {
    private PrintServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrintServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest print(com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPrintMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PrintService.
   */
  public static final class PrintServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PrintServiceFutureStub> {
    private PrintServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PrintServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PrintServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> print(
        com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPrintMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PRINT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PRINT:
          serviceImpl.print((com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest) request,
              (io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getPrintMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest,
              com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest>(
                service, METHODID_PRINT)))
        .build();
  }

  private static abstract class PrintServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PrintServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lizhengpeng.bigger.java.grpc.GrpcServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PrintService");
    }
  }

  private static final class PrintServiceFileDescriptorSupplier
      extends PrintServiceBaseDescriptorSupplier {
    PrintServiceFileDescriptorSupplier() {}
  }

  private static final class PrintServiceMethodDescriptorSupplier
      extends PrintServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PrintServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PrintServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PrintServiceFileDescriptorSupplier())
              .addMethod(getPrintMethod())
              .build();
        }
      }
    }
    return result;
  }
}
