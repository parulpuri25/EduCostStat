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
    comments = "Source: Query1.proto")
public final class Query1ServiceGrpc {

  private Query1ServiceGrpc() {}

  public static final String SERVICE_NAME = "Query1Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.proto.Query1.Query1Request,
      com.example.proto.Query1.Query1Response> getQuery1Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Query1",
      requestType = com.example.proto.Query1.Query1Request.class,
      responseType = com.example.proto.Query1.Query1Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.proto.Query1.Query1Request,
      com.example.proto.Query1.Query1Response> getQuery1Method() {
    io.grpc.MethodDescriptor<com.example.proto.Query1.Query1Request, com.example.proto.Query1.Query1Response> getQuery1Method;
    if ((getQuery1Method = Query1ServiceGrpc.getQuery1Method) == null) {
      synchronized (Query1ServiceGrpc.class) {
        if ((getQuery1Method = Query1ServiceGrpc.getQuery1Method) == null) {
          Query1ServiceGrpc.getQuery1Method = getQuery1Method = 
              io.grpc.MethodDescriptor.<com.example.proto.Query1.Query1Request, com.example.proto.Query1.Query1Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Query1Service", "Query1"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.Query1.Query1Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.Query1.Query1Response.getDefaultInstance()))
                  .setSchemaDescriptor(new Query1ServiceMethodDescriptorSupplier("Query1"))
                  .build();
          }
        }
     }
     return getQuery1Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Query1ServiceStub newStub(io.grpc.Channel channel) {
    return new Query1ServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Query1ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Query1ServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Query1ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Query1ServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class Query1ServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void query1(com.example.proto.Query1.Query1Request request,
        io.grpc.stub.StreamObserver<com.example.proto.Query1.Query1Response> responseObserver) {
      asyncUnimplementedUnaryCall(getQuery1Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQuery1Method(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.proto.Query1.Query1Request,
                com.example.proto.Query1.Query1Response>(
                  this, METHODID_QUERY1)))
          .build();
    }
  }

  /**
   */
  public static final class Query1ServiceStub extends io.grpc.stub.AbstractStub<Query1ServiceStub> {
    private Query1ServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query1ServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query1ServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query1ServiceStub(channel, callOptions);
    }

    /**
     */
    public void query1(com.example.proto.Query1.Query1Request request,
        io.grpc.stub.StreamObserver<com.example.proto.Query1.Query1Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQuery1Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Query1ServiceBlockingStub extends io.grpc.stub.AbstractStub<Query1ServiceBlockingStub> {
    private Query1ServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query1ServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query1ServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query1ServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.proto.Query1.Query1Response query1(com.example.proto.Query1.Query1Request request) {
      return blockingUnaryCall(
          getChannel(), getQuery1Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Query1ServiceFutureStub extends io.grpc.stub.AbstractStub<Query1ServiceFutureStub> {
    private Query1ServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query1ServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query1ServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query1ServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.proto.Query1.Query1Response> query1(
        com.example.proto.Query1.Query1Request request) {
      return futureUnaryCall(
          getChannel().newCall(getQuery1Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY1 = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Query1ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Query1ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY1:
          serviceImpl.query1((com.example.proto.Query1.Query1Request) request,
              (io.grpc.stub.StreamObserver<com.example.proto.Query1.Query1Response>) responseObserver);
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

  private static abstract class Query1ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Query1ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.proto.Query1.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Query1Service");
    }
  }

  private static final class Query1ServiceFileDescriptorSupplier
      extends Query1ServiceBaseDescriptorSupplier {
    Query1ServiceFileDescriptorSupplier() {}
  }

  private static final class Query1ServiceMethodDescriptorSupplier
      extends Query1ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Query1ServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (Query1ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Query1ServiceFileDescriptorSupplier())
              .addMethod(getQuery1Method())
              .build();
        }
      }
    }
    return result;
  }
}
