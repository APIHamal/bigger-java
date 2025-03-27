package com.lizhengpeng.bigger.java.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.60.0)",
    comments = "Source: inteceptor.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EchoServiceGrpc {

  private EchoServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "EchoService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> getEchoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "echo",
      requestType = com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.class,
      responseType = com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> getEchoMethod() {
    io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest, com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> getEchoMethod;
    if ((getEchoMethod = EchoServiceGrpc.getEchoMethod) == null) {
      synchronized (EchoServiceGrpc.class) {
        if ((getEchoMethod = EchoServiceGrpc.getEchoMethod) == null) {
          EchoServiceGrpc.getEchoMethod = getEchoMethod =
              io.grpc.MethodDescriptor.<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest, com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "echo"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.getDefaultInstance()))
              .setSchemaDescriptor(new EchoServiceMethodDescriptorSupplier("echo"))
              .build();
        }
      }
    }
    return getEchoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> getStreamEchoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamEcho",
      requestType = com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.class,
      responseType = com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest,
      com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> getStreamEchoMethod() {
    io.grpc.MethodDescriptor<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest, com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> getStreamEchoMethod;
    if ((getStreamEchoMethod = EchoServiceGrpc.getStreamEchoMethod) == null) {
      synchronized (EchoServiceGrpc.class) {
        if ((getStreamEchoMethod = EchoServiceGrpc.getStreamEchoMethod) == null) {
          EchoServiceGrpc.getStreamEchoMethod = getStreamEchoMethod =
              io.grpc.MethodDescriptor.<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest, com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "streamEcho"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest.getDefaultInstance()))
              .setSchemaDescriptor(new EchoServiceMethodDescriptorSupplier("streamEcho"))
              .build();
        }
      }
    }
    return getStreamEchoMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EchoServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EchoServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EchoServiceStub>() {
        @java.lang.Override
        public EchoServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EchoServiceStub(channel, callOptions);
        }
      };
    return EchoServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EchoServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EchoServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EchoServiceBlockingStub>() {
        @java.lang.Override
        public EchoServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EchoServiceBlockingStub(channel, callOptions);
        }
      };
    return EchoServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EchoServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EchoServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EchoServiceFutureStub>() {
        @java.lang.Override
        public EchoServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EchoServiceFutureStub(channel, callOptions);
        }
      };
    return EchoServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void echo(com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest request,
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEchoMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> streamEcho(
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getStreamEchoMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EchoService.
   */
  public static abstract class EchoServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EchoServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EchoService.
   */
  public static final class EchoServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EchoServiceStub> {
    private EchoServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EchoServiceStub(channel, callOptions);
    }

    /**
     */
    public void echo(com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest request,
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEchoMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> streamEcho(
        io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamEchoMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EchoService.
   */
  public static final class EchoServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EchoServiceBlockingStub> {
    private EchoServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EchoServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest echo(com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEchoMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EchoService.
   */
  public static final class EchoServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EchoServiceFutureStub> {
    private EchoServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EchoServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EchoServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest> echo(
        com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEchoMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ECHO = 0;
  private static final int METHODID_STREAM_ECHO = 1;

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
        case METHODID_ECHO:
          serviceImpl.echo((com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest) request,
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
        case METHODID_STREAM_ECHO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.streamEcho(
              (io.grpc.stub.StreamObserver<com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getEchoMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest,
              com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest>(
                service, METHODID_ECHO)))
        .addMethod(
          getStreamEchoMethod(),
          io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
            new MethodHandlers<
              com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest,
              com.lizhengpeng.bigger.java.grpc.GrpcServer.GrpcRequest>(
                service, METHODID_STREAM_ECHO)))
        .build();
  }

  private static abstract class EchoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EchoServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.lizhengpeng.bigger.java.grpc.GrpcServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EchoService");
    }
  }

  private static final class EchoServiceFileDescriptorSupplier
      extends EchoServiceBaseDescriptorSupplier {
    EchoServiceFileDescriptorSupplier() {}
  }

  private static final class EchoServiceMethodDescriptorSupplier
      extends EchoServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EchoServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EchoServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EchoServiceFileDescriptorSupplier())
              .addMethod(getEchoMethod())
              .addMethod(getStreamEchoMethod())
              .build();
        }
      }
    }
    return result;
  }
}
