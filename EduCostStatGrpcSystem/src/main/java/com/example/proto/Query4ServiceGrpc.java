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
    comments = "Source: Query4.proto")
public final class Query4ServiceGrpc {

  private Query4ServiceGrpc() {}

  public static final String SERVICE_NAME = "Query4Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.proto.Query4.Query4Request,
      com.example.proto.Query4.Query4Response> getQuery4Method;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Query4",
      requestType = com.example.proto.Query4.Query4Request.class,
      responseType = com.example.proto.Query4.Query4Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.proto.Query4.Query4Request,
      com.example.proto.Query4.Query4Response> getQuery4Method() {
    io.grpc.MethodDescriptor<com.example.proto.Query4.Query4Request, com.example.proto.Query4.Query4Response> getQuery4Method;
    if ((getQuery4Method = Query4ServiceGrpc.getQuery4Method) == null) {
      synchronized (Query4ServiceGrpc.class) {
        if ((getQuery4Method = Query4ServiceGrpc.getQuery4Method) == null) {
          Query4ServiceGrpc.getQuery4Method = getQuery4Method = 
              io.grpc.MethodDescriptor.<com.example.proto.Query4.Query4Request, com.example.proto.Query4.Query4Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Query4Service", "Query4"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.Query4.Query4Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.proto.Query4.Query4Response.getDefaultInstance()))
                  .setSchemaDescriptor(new Query4ServiceMethodDescriptorSupplier("Query4"))
                  .build();
          }
        }
     }
     return getQuery4Method;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Query4ServiceStub newStub(io.grpc.Channel channel) {
    return new Query4ServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Query4ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Query4ServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Query4ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Query4ServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class Query4ServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void query4(com.example.proto.Query4.Query4Request request,
        io.grpc.stub.StreamObserver<com.example.proto.Query4.Query4Response> responseObserver) {
      asyncUnimplementedUnaryCall(getQuery4Method(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getQuery4Method(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.proto.Query4.Query4Request,
                com.example.proto.Query4.Query4Response>(
                  this, METHODID_QUERY4)))
          .build();
    }
  }

  /**
   */
  public static final class Query4ServiceStub extends io.grpc.stub.AbstractStub<Query4ServiceStub> {
    private Query4ServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query4ServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query4ServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query4ServiceStub(channel, callOptions);
    }

    /**
     */
    public void query4(com.example.proto.Query4.Query4Request request,
        io.grpc.stub.StreamObserver<com.example.proto.Query4.Query4Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getQuery4Method(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class Query4ServiceBlockingStub extends io.grpc.stub.AbstractStub<Query4ServiceBlockingStub> {
    private Query4ServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query4ServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query4ServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query4ServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.proto.Query4.Query4Response query4(com.example.proto.Query4.Query4Request request) {
      return blockingUnaryCall(
          getChannel(), getQuery4Method(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class Query4ServiceFutureStub extends io.grpc.stub.AbstractStub<Query4ServiceFutureStub> {
    private Query4ServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Query4ServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Query4ServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Query4ServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.proto.Query4.Query4Response> query4(
        com.example.proto.Query4.Query4Request request) {
      return futureUnaryCall(
          getChannel().newCall(getQuery4Method(), getCallOptions()), request);
    }
  }

  private static final int METHODID_QUERY4 = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Query4ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Query4ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_QUERY4:
          serviceImpl.query4((com.example.proto.Query4.Query4Request) request,
              (io.grpc.stub.StreamObserver<com.example.proto.Query4.Query4Response>) responseObserver);
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

  private static abstract class Query4ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Query4ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.proto.Query4.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Query4Service");
    }
  }

  private static final class Query4ServiceFileDescriptorSupplier
      extends Query4ServiceBaseDescriptorSupplier {
    Query4ServiceFileDescriptorSupplier() {}
  }

  private static final class Query4ServiceMethodDescriptorSupplier
      extends Query4ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Query4ServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (Query4ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Query4ServiceFileDescriptorSupplier())
              .addMethod(getQuery4Method())
              .build();
        }
      }
    }
    return result;
  }
}
