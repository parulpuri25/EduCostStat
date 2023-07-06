package com.example.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Query3.proto")
public final class Query3ServiceGrpc {

  private Query3ServiceGrpc() {}

  public static final String SERVICE_NAME = "Query3Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.proto.Query3.Query3Request,
      com.example.proto.Query3.Query3Response> getQuery3Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Query3",
      requestType = com.example.proto.Query3.Query3Request.class,
      responseType = com.example.proto.Query3.Query3Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.proto.Query3.Query3Request,
      com.example.proto.Query3.Query3Response> getQuery3Method() {
    io.grpc.MethodDescriptor<com.example.proto.Query3.Query3Request, com.example.proto.Query3.Query3Response> getQuery3Method;
    if ((getQuery3Method = Query3ServiceGrpc.getQuery3Method) == null) {
      synchronized (Query3ServiceGrpc.class) {
        if ((getQuery3Method = Query3ServiceGrpc.getQuery3Method) == null) {
          Query3ServiceGrpc.getQuery3Method = getQuery3Method = 
              io.grpc.MethodDescriptor.<com.example.proto.Query3.Query3Request, com.example.proto.Query3.Query3Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Query3Service", "Query3"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.Query3.Query3Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.Query3.Query3Response.getDefaultInstance()))
                  .setSchemaDescriptor(new Query3ServiceMethodDescriptorSupplier("Query3"))
                  .build();
          }
        }
     }
     return getQuery3Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Query3ServiceStub newStub(io.grpc.Channel channel) {
    return new Query3ServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Query3ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Query3ServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Query3ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Query3ServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class Query3ServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void query3(com.example.proto.Query3.Query3Request request,
        io.grpc.stub.StreamObserver<com.example.proto.Query3.Query3Response> responseObserver) {
      asyncUnimplementedUnaryCall(getQuery3Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQuery3Method(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.proto.Query3.Query3Request,
                com.example.proto.Query3.Query3Response>(
                  this, METHODID_QUERY3)))
          .build();
    }
  }

  /**
   */
  public static final class Query3ServiceStub extends io.grpc.stub.AbstractStub<Query3ServiceStub> {
    private Query3ServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query3ServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query3ServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query3ServiceStub(channel, callOptions);
    }

    /**
     */
    public void query3(com.example.proto.Query3.Query3Request request,
        io.grpc.stub.StreamObserver<com.example.proto.Query3.Query3Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQuery3Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Query3ServiceBlockingStub extends io.grpc.stub.AbstractStub<Query3ServiceBlockingStub> {
    private Query3ServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query3ServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query3ServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query3ServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.proto.Query3.Query3Response query3(com.example.proto.Query3.Query3Request request) {
      return blockingUnaryCall(
          getChannel(), getQuery3Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Query3ServiceFutureStub extends io.grpc.stub.AbstractStub<Query3ServiceFutureStub> {
    private Query3ServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query3ServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query3ServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query3ServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.proto.Query3.Query3Response> query3(
        com.example.proto.Query3.Query3Request request) {
      return futureUnaryCall(
          getChannel().newCall(getQuery3Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY3 = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Query3ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Query3ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY3:
          serviceImpl.query3((com.example.proto.Query3.Query3Request) request,
              (io.grpc.stub.StreamObserver<com.example.proto.Query3.Query3Response>) responseObserver);
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

  private static abstract class Query3ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Query3ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.proto.Query3.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Query3Service");
    }
  }

  private static final class Query3ServiceFileDescriptorSupplier
      extends Query3ServiceBaseDescriptorSupplier {
    Query3ServiceFileDescriptorSupplier() {}
  }

  private static final class Query3ServiceMethodDescriptorSupplier
      extends Query3ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Query3ServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (Query3ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Query3ServiceFileDescriptorSupplier())
              .addMethod(getQuery3Method())
              .build();
        }
      }
    }
    return result;
  }
}
