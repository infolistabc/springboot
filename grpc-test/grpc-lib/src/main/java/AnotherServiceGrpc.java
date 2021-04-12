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
    value = "by gRPC proto compiler (version 1.31.1)",
    comments = "Source: another_service.proto")
public final class AnotherServiceGrpc {

  private AnotherServiceGrpc() {}

  public static final String SERVICE_NAME = "AnotherService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<AnotherServiceOuterClass.AnotherRequest,
      AnotherServiceOuterClass.AnotherReplay> getAnotherHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnotherHello",
      requestType = AnotherServiceOuterClass.AnotherRequest.class,
      responseType = AnotherServiceOuterClass.AnotherReplay.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AnotherServiceOuterClass.AnotherRequest,
      AnotherServiceOuterClass.AnotherReplay> getAnotherHelloMethod() {
    io.grpc.MethodDescriptor<AnotherServiceOuterClass.AnotherRequest, AnotherServiceOuterClass.AnotherReplay> getAnotherHelloMethod;
    if ((getAnotherHelloMethod = AnotherServiceGrpc.getAnotherHelloMethod) == null) {
      synchronized (AnotherServiceGrpc.class) {
        if ((getAnotherHelloMethod = AnotherServiceGrpc.getAnotherHelloMethod) == null) {
          AnotherServiceGrpc.getAnotherHelloMethod = getAnotherHelloMethod =
              io.grpc.MethodDescriptor.<AnotherServiceOuterClass.AnotherRequest, AnotherServiceOuterClass.AnotherReplay>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnotherHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AnotherServiceOuterClass.AnotherRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AnotherServiceOuterClass.AnotherReplay.getDefaultInstance()))
              .setSchemaDescriptor(new AnotherServiceMethodDescriptorSupplier("AnotherHello"))
              .build();
        }
      }
    }
    return getAnotherHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AnotherServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnotherServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnotherServiceStub>() {
        @java.lang.Override
        public AnotherServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnotherServiceStub(channel, callOptions);
        }
      };
    return AnotherServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AnotherServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnotherServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnotherServiceBlockingStub>() {
        @java.lang.Override
        public AnotherServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnotherServiceBlockingStub(channel, callOptions);
        }
      };
    return AnotherServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AnotherServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AnotherServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AnotherServiceFutureStub>() {
        @java.lang.Override
        public AnotherServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AnotherServiceFutureStub(channel, callOptions);
        }
      };
    return AnotherServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AnotherServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void anotherHello(AnotherServiceOuterClass.AnotherRequest request,
        io.grpc.stub.StreamObserver<AnotherServiceOuterClass.AnotherReplay> responseObserver) {
      asyncUnimplementedUnaryCall(getAnotherHelloMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAnotherHelloMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                AnotherServiceOuterClass.AnotherRequest,
                AnotherServiceOuterClass.AnotherReplay>(
                  this, METHODID_ANOTHER_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class AnotherServiceStub extends io.grpc.stub.AbstractAsyncStub<AnotherServiceStub> {
    private AnotherServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnotherServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnotherServiceStub(channel, callOptions);
    }

    /**
     */
    public void anotherHello(AnotherServiceOuterClass.AnotherRequest request,
        io.grpc.stub.StreamObserver<AnotherServiceOuterClass.AnotherReplay> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnotherHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AnotherServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AnotherServiceBlockingStub> {
    private AnotherServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnotherServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnotherServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public AnotherServiceOuterClass.AnotherReplay anotherHello(AnotherServiceOuterClass.AnotherRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnotherHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AnotherServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AnotherServiceFutureStub> {
    private AnotherServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AnotherServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AnotherServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<AnotherServiceOuterClass.AnotherReplay> anotherHello(
        AnotherServiceOuterClass.AnotherRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnotherHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ANOTHER_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AnotherServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AnotherServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ANOTHER_HELLO:
          serviceImpl.anotherHello((AnotherServiceOuterClass.AnotherRequest) request,
              (io.grpc.stub.StreamObserver<AnotherServiceOuterClass.AnotherReplay>) responseObserver);
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

  private static abstract class AnotherServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AnotherServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return AnotherServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AnotherService");
    }
  }

  private static final class AnotherServiceFileDescriptorSupplier
      extends AnotherServiceBaseDescriptorSupplier {
    AnotherServiceFileDescriptorSupplier() {}
  }

  private static final class AnotherServiceMethodDescriptorSupplier
      extends AnotherServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AnotherServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AnotherServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AnotherServiceFileDescriptorSupplier())
              .addMethod(getAnotherHelloMethod())
              .build();
        }
      }
    }
    return result;
  }
}
