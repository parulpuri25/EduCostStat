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
    comments = "Source: Query2.proto")
public final class Query2ServiceGrpc {

  private Query2ServiceGrpc() {}

  public static final String SERVICE_NAME = "Query2Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.proto.Query2.Query2Request,
      com.example.proto.Query2.Query2Response> getQuery2Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Query2",
      requestType = com.example.proto.Query2.Query2Request.class,
      responseType = com.example.proto.Query2.Query2Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.proto.Query2.Query2Request,
      com.example.proto.Query2.Query2Response> getQuery2Method() {
    io.grpc.MethodDescriptor<com.example.proto.Query2.Query2Request, com.example.proto.Query2.Query2Response> getQuery2Method;
    if ((getQuery2Method = Query2ServiceGrpc.getQuery2Method) == null) {
      synchronized (Query2ServiceGrpc.class) {
        if ((getQuery2Method = Query2ServiceGrpc.getQuery2Method) == null) {
          Query2ServiceGrpc.getQuery2Method = getQuery2Method = 
              io.grpc.MethodDescriptor.<com.example.proto.Query2.Query2Request, com.example.proto.Query2.Query2Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Query2Service", "Query2"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.Query2.Query2Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.Query2.Query2Response.getDefaultInstance()))
                  .setSchemaDescriptor(new Query2ServiceMethodDescriptorSupplier("Query2"))
                  .build();
          }
        }
     }
     return getQuery2Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Query2ServiceStub newStub(io.grpc.Channel channel) {
    return new Query2ServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Query2ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Query2ServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Query2ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Query2ServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class Query2ServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void query2(com.example.proto.Query2.Query2Request request,
        io.grpc.stub.StreamObserver<com.example.proto.Query2.Query2Response> responseObserver) {
      asyncUnimplementedUnaryCall(getQuery2Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQuery2Method(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.proto.Query2.Query2Request,
                com.example.proto.Query2.Query2Response>(
                  this, METHODID_QUERY2)))
          .build();
    }
  }

  /**
   */
  public static final class Query2ServiceStub extends io.grpc.stub.AbstractStub<Query2ServiceStub> {
    private Query2ServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query2ServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query2ServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query2ServiceStub(channel, callOptions);
    }

    /**
     */
    public void query2(com.example.proto.Query2.Query2Request request,
        io.grpc.stub.StreamObserver<com.example.proto.Query2.Query2Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQuery2Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Query2ServiceBlockingStub extends io.grpc.stub.AbstractStub<Query2ServiceBlockingStub> {
    private Query2ServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query2ServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query2ServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query2ServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.proto.Query2.Query2Response query2(com.example.proto.Query2.Query2Request request) {
      return blockingUnaryCall(
          getChannel(), getQuery2Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Query2ServiceFutureStub extends io.grpc.stub.AbstractStub<Query2ServiceFutureStub> {
    private Query2ServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query2ServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query2ServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query2ServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.proto.Query2.Query2Response> query2(
        com.example.proto.Query2.Query2Request request) {
      return futureUnaryCall(
          getChannel().newCall(getQuery2Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY2 = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Query2ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Query2ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY2:
          serviceImpl.query2((com.example.proto.Query2.Query2Request) request,
              (io.grpc.stub.StreamObserver<com.example.proto.Query2.Query2Response>) responseObserver);
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

  private static abstract class Query2ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Query2ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.proto.Query2.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Query2Service");
    }
  }

  private static final class Query2ServiceFileDescriptorSupplier
      extends Query2ServiceBaseDescriptorSupplier {
    Query2ServiceFileDescriptorSupplier() {}
  }

  private static final class Query2ServiceMethodDescriptorSupplier
      extends Query2ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Query2ServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (Query2ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Query2ServiceFileDescriptorSupplier())
              .addMethod(getQuery2Method())
              .build();
        }
      }
    }
    return result;
  }
}
