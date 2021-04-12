package grpc_code.greeter;

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
 * <pre>
 * 服务名
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.31.1)",
    comments = "Source: hellowold.proto")
public final class GreeterGrpc {

  private GreeterGrpc() {}

  public static final String SERVICE_NAME = "Greeter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest,
      grpc_code.greeter.Hellowold.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = grpc_code.greeter.Hellowold.HelloRequest.class,
      responseType = grpc_code.greeter.Hellowold.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest,
      grpc_code.greeter.Hellowold.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest, grpc_code.greeter.Hellowold.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getSayHelloMethod = GreeterGrpc.getSayHelloMethod) == null) {
          GreeterGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<grpc_code.greeter.Hellowold.HelloRequest, grpc_code.greeter.Hellowold.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc_code.greeter.Hellowold.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc_code.greeter.Hellowold.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest,
      grpc_code.greeter.Hellowold.HelloReply> getLotsOfRepliesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LotsOfReplies",
      requestType = grpc_code.greeter.Hellowold.HelloRequest.class,
      responseType = grpc_code.greeter.Hellowold.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest,
      grpc_code.greeter.Hellowold.HelloReply> getLotsOfRepliesMethod() {
    io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest, grpc_code.greeter.Hellowold.HelloReply> getLotsOfRepliesMethod;
    if ((getLotsOfRepliesMethod = GreeterGrpc.getLotsOfRepliesMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getLotsOfRepliesMethod = GreeterGrpc.getLotsOfRepliesMethod) == null) {
          GreeterGrpc.getLotsOfRepliesMethod = getLotsOfRepliesMethod =
              io.grpc.MethodDescriptor.<grpc_code.greeter.Hellowold.HelloRequest, grpc_code.greeter.Hellowold.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LotsOfReplies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc_code.greeter.Hellowold.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc_code.greeter.Hellowold.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("LotsOfReplies"))
              .build();
        }
      }
    }
    return getLotsOfRepliesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest1,
      grpc_code.greeter.Hellowold.HelloReply> getLotsOfGreetingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LotsOfGreetings",
      requestType = grpc_code.greeter.Hellowold.HelloRequest1.class,
      responseType = grpc_code.greeter.Hellowold.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest1,
      grpc_code.greeter.Hellowold.HelloReply> getLotsOfGreetingsMethod() {
    io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest1, grpc_code.greeter.Hellowold.HelloReply> getLotsOfGreetingsMethod;
    if ((getLotsOfGreetingsMethod = GreeterGrpc.getLotsOfGreetingsMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getLotsOfGreetingsMethod = GreeterGrpc.getLotsOfGreetingsMethod) == null) {
          GreeterGrpc.getLotsOfGreetingsMethod = getLotsOfGreetingsMethod =
              io.grpc.MethodDescriptor.<grpc_code.greeter.Hellowold.HelloRequest1, grpc_code.greeter.Hellowold.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LotsOfGreetings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc_code.greeter.Hellowold.HelloRequest1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc_code.greeter.Hellowold.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("LotsOfGreetings"))
              .build();
        }
      }
    }
    return getLotsOfGreetingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest1,
      grpc_code.greeter.Hellowold.HelloReply> getBidiHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BidiHello",
      requestType = grpc_code.greeter.Hellowold.HelloRequest1.class,
      responseType = grpc_code.greeter.Hellowold.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest1,
      grpc_code.greeter.Hellowold.HelloReply> getBidiHelloMethod() {
    io.grpc.MethodDescriptor<grpc_code.greeter.Hellowold.HelloRequest1, grpc_code.greeter.Hellowold.HelloReply> getBidiHelloMethod;
    if ((getBidiHelloMethod = GreeterGrpc.getBidiHelloMethod) == null) {
      synchronized (GreeterGrpc.class) {
        if ((getBidiHelloMethod = GreeterGrpc.getBidiHelloMethod) == null) {
          GreeterGrpc.getBidiHelloMethod = getBidiHelloMethod =
              io.grpc.MethodDescriptor.<grpc_code.greeter.Hellowold.HelloRequest1, grpc_code.greeter.Hellowold.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BidiHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc_code.greeter.Hellowold.HelloRequest1.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc_code.greeter.Hellowold.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new GreeterMethodDescriptorSupplier("BidiHello"))
              .build();
        }
      }
    }
    return getBidiHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreeterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterStub>() {
        @java.lang.Override
        public GreeterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterStub(channel, callOptions);
        }
      };
    return GreeterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreeterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterBlockingStub>() {
        @java.lang.Override
        public GreeterBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterBlockingStub(channel, callOptions);
        }
      };
    return GreeterBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreeterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreeterFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreeterFutureStub>() {
        @java.lang.Override
        public GreeterFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreeterFutureStub(channel, callOptions);
        }
      };
    return GreeterFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 服务名
   * </pre>
   */
  public static abstract class GreeterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 接口声明, 类似http 的一来一回短消息
     * </pre>
     */
    public void sayHello(grpc_code.greeter.Hellowold.HelloRequest request,
        io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     * <pre>
     * server stream    client端短连接 server端长连接
     * </pre>
     */
    public void lotsOfReplies(grpc_code.greeter.Hellowold.HelloRequest request,
        io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply> responseObserver) {
      asyncUnimplementedUnaryCall(getLotsOfRepliesMethod(), responseObserver);
    }

    /**
     * <pre>
     * client stream    server端短连接 client端长连接
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloRequest1> lotsOfGreetings(
        io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getLotsOfGreetingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional streaming      client,server全部长连接
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloRequest1> bidiHello(
        io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getBidiHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc_code.greeter.Hellowold.HelloRequest,
                grpc_code.greeter.Hellowold.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getLotsOfRepliesMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc_code.greeter.Hellowold.HelloRequest,
                grpc_code.greeter.Hellowold.HelloReply>(
                  this, METHODID_LOTS_OF_REPLIES)))
          .addMethod(
            getLotsOfGreetingsMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc_code.greeter.Hellowold.HelloRequest1,
                grpc_code.greeter.Hellowold.HelloReply>(
                  this, METHODID_LOTS_OF_GREETINGS)))
          .addMethod(
            getBidiHelloMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc_code.greeter.Hellowold.HelloRequest1,
                grpc_code.greeter.Hellowold.HelloReply>(
                  this, METHODID_BIDI_HELLO)))
          .build();
    }
  }

  /**
   * <pre>
   * 服务名
   * </pre>
   */
  public static final class GreeterStub extends io.grpc.stub.AbstractAsyncStub<GreeterStub> {
    private GreeterStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterStub(channel, callOptions);
    }

    /**
     * <pre>
     * 接口声明, 类似http 的一来一回短消息
     * </pre>
     */
    public void sayHello(grpc_code.greeter.Hellowold.HelloRequest request,
        io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * server stream    client端短连接 server端长连接
     * </pre>
     */
    public void lotsOfReplies(grpc_code.greeter.Hellowold.HelloRequest request,
        io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLotsOfRepliesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * client stream    server端短连接 client端长连接
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloRequest1> lotsOfGreetings(
        io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getLotsOfGreetingsMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional streaming      client,server全部长连接
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloRequest1> bidiHello(
        io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBidiHelloMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * 服务名
   * </pre>
   */
  public static final class GreeterBlockingStub extends io.grpc.stub.AbstractBlockingStub<GreeterBlockingStub> {
    private GreeterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 接口声明, 类似http 的一来一回短消息
     * </pre>
     */
    public grpc_code.greeter.Hellowold.HelloReply sayHello(grpc_code.greeter.Hellowold.HelloRequest request) {
      return blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * server stream    client端短连接 server端长连接
     * </pre>
     */
    public java.util.Iterator<grpc_code.greeter.Hellowold.HelloReply> lotsOfReplies(
        grpc_code.greeter.Hellowold.HelloRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getLotsOfRepliesMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 服务名
   * </pre>
   */
  public static final class GreeterFutureStub extends io.grpc.stub.AbstractFutureStub<GreeterFutureStub> {
    private GreeterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreeterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreeterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 接口声明, 类似http 的一来一回短消息
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc_code.greeter.Hellowold.HelloReply> sayHello(
        grpc_code.greeter.Hellowold.HelloRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_LOTS_OF_REPLIES = 1;
  private static final int METHODID_LOTS_OF_GREETINGS = 2;
  private static final int METHODID_BIDI_HELLO = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreeterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreeterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((grpc_code.greeter.Hellowold.HelloRequest) request,
              (io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply>) responseObserver);
          break;
        case METHODID_LOTS_OF_REPLIES:
          serviceImpl.lotsOfReplies((grpc_code.greeter.Hellowold.HelloRequest) request,
              (io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply>) responseObserver);
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
        case METHODID_LOTS_OF_GREETINGS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.lotsOfGreetings(
              (io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply>) responseObserver);
        case METHODID_BIDI_HELLO:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.bidiHello(
              (io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GreeterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc_code.greeter.Hellowold.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Greeter");
    }
  }

  private static final class GreeterFileDescriptorSupplier
      extends GreeterBaseDescriptorSupplier {
    GreeterFileDescriptorSupplier() {}
  }

  private static final class GreeterMethodDescriptorSupplier
      extends GreeterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GreeterMethodDescriptorSupplier(String methodName) {
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
      synchronized (GreeterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GreeterFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getLotsOfRepliesMethod())
              .addMethod(getLotsOfGreetingsMethod())
              .addMethod(getBidiHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
