package com.lizhengpeng.bigger.java.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.0)",
    comments = "Source: inteceptor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FallbackServiceGrpc {

  private FallbackServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "FallbackService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getUnaryEchoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "unaryEcho",
      requestType = com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.class,
      responseType = com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getUnaryEchoMethod() {
    io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload, com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getUnaryEchoMethod;
    if ((getUnaryEchoMethod = FallbackServiceGrpc.getUnaryEchoMethod) == null) {
      synchronized (FallbackServiceGrpc.class) {
        if ((getUnaryEchoMethod = FallbackServiceGrpc.getUnaryEchoMethod) == null) {
          FallbackServiceGrpc.getUnaryEchoMethod = getUnaryEchoMethod =
              io.grpc.MethodDescriptor.<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload, com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "unaryEcho"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.getDefaultInstance()))
              .setSchemaDescriptor(new FallbackServiceMethodDescriptorSupplier("unaryEcho"))
              .build();
        }
      }
    }
    return getUnaryEchoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getClientStreamEchoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "clientStreamEcho",
      requestType = com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.class,
      responseType = com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getClientStreamEchoMethod() {
    io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload, com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getClientStreamEchoMethod;
    if ((getClientStreamEchoMethod = FallbackServiceGrpc.getClientStreamEchoMethod) == null) {
      synchronized (FallbackServiceGrpc.class) {
        if ((getClientStreamEchoMethod = FallbackServiceGrpc.getClientStreamEchoMethod) == null) {
          FallbackServiceGrpc.getClientStreamEchoMethod = getClientStreamEchoMethod =
              io.grpc.MethodDescriptor.<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload, com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "clientStreamEcho"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.getDefaultInstance()))
              .setSchemaDescriptor(new FallbackServiceMethodDescriptorSupplier("clientStreamEcho"))
              .build();
        }
      }
    }
    return getClientStreamEchoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getServerStreamEchoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "serverStreamEcho",
      requestType = com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.class,
      responseType = com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getServerStreamEchoMethod() {
    io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload, com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getServerStreamEchoMethod;
    if ((getServerStreamEchoMethod = FallbackServiceGrpc.getServerStreamEchoMethod) == null) {
      synchronized (FallbackServiceGrpc.class) {
        if ((getServerStreamEchoMethod = FallbackServiceGrpc.getServerStreamEchoMethod) == null) {
          FallbackServiceGrpc.getServerStreamEchoMethod = getServerStreamEchoMethod =
              io.grpc.MethodDescriptor.<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload, com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "serverStreamEcho"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.getDefaultInstance()))
              .setSchemaDescriptor(new FallbackServiceMethodDescriptorSupplier("serverStreamEcho"))
              .build();
        }
      }
    }
    return getServerStreamEchoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getDoubleStreamEchoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "doubleStreamEcho",
      requestType = com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.class,
      responseType = com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getDoubleStreamEchoMethod() {
    io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload, com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> getDoubleStreamEchoMethod;
    if ((getDoubleStreamEchoMethod = FallbackServiceGrpc.getDoubleStreamEchoMethod) == null) {
      synchronized (FallbackServiceGrpc.class) {
        if ((getDoubleStreamEchoMethod = FallbackServiceGrpc.getDoubleStreamEchoMethod) == null) {
          FallbackServiceGrpc.getDoubleStreamEchoMethod = getDoubleStreamEchoMethod =
              io.grpc.MethodDescriptor.<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload, com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "doubleStreamEcho"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload.getDefaultInstance()))
              .setSchemaDescriptor(new FallbackServiceMethodDescriptorSupplier("doubleStreamEcho"))
              .build();
        }
      }
    }
    return getDoubleStreamEchoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FallbackServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FallbackServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FallbackServiceStub>() {
        @java.lang.Override
        public FallbackServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FallbackServiceStub(channel, callOptions);
        }
      };
    return FallbackServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FallbackServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FallbackServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FallbackServiceBlockingStub>() {
        @java.lang.Override
        public FallbackServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FallbackServiceBlockingStub(channel, callOptions);
        }
      };
    return FallbackServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FallbackServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FallbackServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FallbackServiceFutureStub>() {
        @java.lang.Override
        public FallbackServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FallbackServiceFutureStub(channel, callOptions);
        }
      };
    return FallbackServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void unaryEcho(com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload request,
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnaryEchoMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> clientStreamEcho(
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getClientStreamEchoMethod(), responseObserver);
    }

    /**
     */
    default void serverStreamEcho(com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload request,
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerStreamEchoMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> doubleStreamEcho(
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getDoubleStreamEchoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FallbackService.
   */
  public static abstract class FallbackServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FallbackServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FallbackService.
   */
  public static final class FallbackServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FallbackServiceStub> {
    private FallbackServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FallbackServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FallbackServiceStub(channel, callOptions);
    }

    /**
     */
    public void unaryEcho(com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload request,
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnaryEchoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> clientStreamEcho(
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getClientStreamEchoMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void serverStreamEcho(com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload request,
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getServerStreamEchoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> doubleStreamEcho(
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getDoubleStreamEchoMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FallbackService.
   */
  public static final class FallbackServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FallbackServiceBlockingStub> {
    private FallbackServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FallbackServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FallbackServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload unaryEcho(com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnaryEchoMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> serverStreamEcho(
        com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getServerStreamEchoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FallbackService.
   */
  public static final class FallbackServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FallbackServiceFutureStub> {
    private FallbackServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FallbackServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FallbackServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload> unaryEcho(
        com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnaryEchoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UNARY_ECHO = 0;
  private static final int METHODID_SERVER_STREAM_ECHO = 1;
  private static final int METHODID_CLIENT_STREAM_ECHO = 2;
  private static final int METHODID_DOUBLE_STREAM_ECHO = 3;

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
        case METHODID_UNARY_ECHO:
          serviceImpl.unaryEcho((com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload) request,
              (io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>) responseObserver);
          break;
        case METHODID_SERVER_STREAM_ECHO:
          serviceImpl.serverStreamEcho((com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload) request,
              (io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>) responseObserver);
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
        case METHODID_CLIENT_STREAM_ECHO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStreamEcho(
              (io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>) responseObserver);
        case METHODID_DOUBLE_STREAM_ECHO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.doubleStreamEcho(
              (io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getUnaryEchoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
              com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>(
                service, METHODID_UNARY_ECHO)))
        .addMethod(
          getClientStreamEchoMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
              com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>(
                service, METHODID_CLIENT_STREAM_ECHO)))
        .addMethod(
          getServerStreamEchoMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
              com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>(
                service, METHODID_SERVER_STREAM_ECHO)))
        .addMethod(
          getDoubleStreamEchoMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload,
              com.lizhengpeng.bigger.java.grpc.GrpcServer.Payload>(
                service, METHODID_DOUBLE_STREAM_ECHO)))
        .build();
  }

  private static abstract class FallbackServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FallbackServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lizhengpeng.bigger.java.grpc.GrpcServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FallbackService");
    }
  }

  private static final class FallbackServiceFileDescriptorSupplier
      extends FallbackServiceBaseDescriptorSupplier {
    FallbackServiceFileDescriptorSupplier() {}
  }

  private static final class FallbackServiceMethodDescriptorSupplier
      extends FallbackServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FallbackServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FallbackServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FallbackServiceFileDescriptorSupplier())
              .addMethod(getUnaryEchoMethod())
              .addMethod(getClientStreamEchoMethod())
              .addMethod(getServerStreamEchoMethod())
              .addMethod(getDoubleStreamEchoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
