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
    comments = "Source: Query5.proto")
public final class Query5ServiceGrpc {

  private Query5ServiceGrpc() {}

  public static final String SERVICE_NAME = "Query5Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.proto.Query5.Query5Request,
      com.example.proto.Query5.Query5Response> getQuery5Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Query5",
      requestType = com.example.proto.Query5.Query5Request.class,
      responseType = com.example.proto.Query5.Query5Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.proto.Query5.Query5Request,
      com.example.proto.Query5.Query5Response> getQuery5Method() {
    io.grpc.MethodDescriptor<com.example.proto.Query5.Query5Request, com.example.proto.Query5.Query5Response> getQuery5Method;
    if ((getQuery5Method = Query5ServiceGrpc.getQuery5Method) == null) {
      synchronized (Query5ServiceGrpc.class) {
        if ((getQuery5Method = Query5ServiceGrpc.getQuery5Method) == null) {
          Query5ServiceGrpc.getQuery5Method = getQuery5Method = 
              io.grpc.MethodDescriptor.<com.example.proto.Query5.Query5Request, com.example.proto.Query5.Query5Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Query5Service", "Query5"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.Query5.Query5Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.Query5.Query5Response.getDefaultInstance()))
                  .setSchemaDescriptor(new Query5ServiceMethodDescriptorSupplier("Query5"))
                  .build();
          }
        }
     }
     return getQuery5Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Query5ServiceStub newStub(io.grpc.Channel channel) {
    return new Query5ServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Query5ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Query5ServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Query5ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Query5ServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class Query5ServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void query5(com.example.proto.Query5.Query5Request request,
        io.grpc.stub.StreamObserver<com.example.proto.Query5.Query5Response> responseObserver) {
      asyncUnimplementedUnaryCall(getQuery5Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQuery5Method(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.proto.Query5.Query5Request,
                com.example.proto.Query5.Query5Response>(
                  this, METHODID_QUERY5)))
          .build();
    }
  }

  /**
   */
  public static final class Query5ServiceStub extends io.grpc.stub.AbstractStub<Query5ServiceStub> {
    private Query5ServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query5ServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query5ServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query5ServiceStub(channel, callOptions);
    }

    /**
     */
    public void query5(com.example.proto.Query5.Query5Request request,
        io.grpc.stub.StreamObserver<com.example.proto.Query5.Query5Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQuery5Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Query5ServiceBlockingStub extends io.grpc.stub.AbstractStub<Query5ServiceBlockingStub> {
    private Query5ServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query5ServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query5ServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query5ServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.proto.Query5.Query5Response query5(com.example.proto.Query5.Query5Request request) {
      return blockingUnaryCall(
          getChannel(), getQuery5Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Query5ServiceFutureStub extends io.grpc.stub.AbstractStub<Query5ServiceFutureStub> {
    private Query5ServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query5ServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query5ServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query5ServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.proto.Query5.Query5Response> query5(
        com.example.proto.Query5.Query5Request request) {
      return futureUnaryCall(
          getChannel().newCall(getQuery5Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY5 = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Query5ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Query5ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY5:
          serviceImpl.query5((com.example.proto.Query5.Query5Request) request,
              (io.grpc.stub.StreamObserver<com.example.proto.Query5.Query5Response>) responseObserver);
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

  private static abstract class Query5ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Query5ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.proto.Query5.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Query5Service");
    }
  }

  private static final class Query5ServiceFileDescriptorSupplier
      extends Query5ServiceBaseDescriptorSupplier {
    Query5ServiceFileDescriptorSupplier() {}
  }

  private static final class Query5ServiceMethodDescriptorSupplier
      extends Query5ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Query5ServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (Query5ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Query5ServiceFileDescriptorSupplier())
              .addMethod(getQuery5Method())
              .build();
        }
      }
    }
    return result;
  }
}
