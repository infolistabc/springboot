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
 * 主动拉去数据
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.31.1)",
    comments = "Source: instance_expect.proto")
public final class ExpectGrpc {

  private ExpectGrpc() {}

  public static final String SERVICE_NAME = "Expect";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<InstanceExpect.InstanceExpectRequest,
      InstanceExpect.InstanceExpectResponse> getGetExpectDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetExpectData",
      requestType = InstanceExpect.InstanceExpectRequest.class,
      responseType = InstanceExpect.InstanceExpectResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<InstanceExpect.InstanceExpectRequest,
      InstanceExpect.InstanceExpectResponse> getGetExpectDataMethod() {
    io.grpc.MethodDescriptor<InstanceExpect.InstanceExpectRequest, InstanceExpect.InstanceExpectResponse> getGetExpectDataMethod;
    if ((getGetExpectDataMethod = ExpectGrpc.getGetExpectDataMethod) == null) {
      synchronized (ExpectGrpc.class) {
        if ((getGetExpectDataMethod = ExpectGrpc.getGetExpectDataMethod) == null) {
          ExpectGrpc.getGetExpectDataMethod = getGetExpectDataMethod =
              io.grpc.MethodDescriptor.<InstanceExpect.InstanceExpectRequest, InstanceExpect.InstanceExpectResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetExpectData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  InstanceExpect.InstanceExpectRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  InstanceExpect.InstanceExpectResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ExpectMethodDescriptorSupplier("GetExpectData"))
              .build();
        }
      }
    }
    return getGetExpectDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExpectStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExpectStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExpectStub>() {
        @java.lang.Override
        public ExpectStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExpectStub(channel, callOptions);
        }
      };
    return ExpectStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExpectBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExpectBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExpectBlockingStub>() {
        @java.lang.Override
        public ExpectBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExpectBlockingStub(channel, callOptions);
        }
      };
    return ExpectBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExpectFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExpectFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExpectFutureStub>() {
        @java.lang.Override
        public ExpectFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExpectFutureStub(channel, callOptions);
        }
      };
    return ExpectFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 主动拉去数据
   * </pre>
   */
  public static abstract class ExpectImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *拉去期望数据
     *    获取期望数据接口，进行处理（期望处理状态-0，2(有重试机制就加上处理失败的)）
     *      创建实例-需要data
     *      更新实例-需要data
     *      启/停实例
     *      删除实例
     *      删除实例存储
     * </pre>
     */
    public void getExpectData(InstanceExpect.InstanceExpectRequest request,
        io.grpc.stub.StreamObserver<InstanceExpect.InstanceExpectResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetExpectDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetExpectDataMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                InstanceExpect.InstanceExpectRequest,
                InstanceExpect.InstanceExpectResponse>(
                  this, METHODID_GET_EXPECT_DATA)))
          .build();
    }
  }

  /**
   * <pre>
   * 主动拉去数据
   * </pre>
   */
  public static final class ExpectStub extends io.grpc.stub.AbstractAsyncStub<ExpectStub> {
    private ExpectStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExpectStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExpectStub(channel, callOptions);
    }

    /**
     * <pre>
     *拉去期望数据
     *    获取期望数据接口，进行处理（期望处理状态-0，2(有重试机制就加上处理失败的)）
     *      创建实例-需要data
     *      更新实例-需要data
     *      启/停实例
     *      删除实例
     *      删除实例存储
     * </pre>
     */
    public void getExpectData(InstanceExpect.InstanceExpectRequest request,
        io.grpc.stub.StreamObserver<InstanceExpect.InstanceExpectResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetExpectDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 主动拉去数据
   * </pre>
   */
  public static final class ExpectBlockingStub extends io.grpc.stub.AbstractBlockingStub<ExpectBlockingStub> {
    private ExpectBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExpectBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExpectBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *拉去期望数据
     *    获取期望数据接口，进行处理（期望处理状态-0，2(有重试机制就加上处理失败的)）
     *      创建实例-需要data
     *      更新实例-需要data
     *      启/停实例
     *      删除实例
     *      删除实例存储
     * </pre>
     */
    public InstanceExpect.InstanceExpectResponse getExpectData(InstanceExpect.InstanceExpectRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetExpectDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 主动拉去数据
   * </pre>
   */
  public static final class ExpectFutureStub extends io.grpc.stub.AbstractFutureStub<ExpectFutureStub> {
    private ExpectFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExpectFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExpectFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *拉去期望数据
     *    获取期望数据接口，进行处理（期望处理状态-0，2(有重试机制就加上处理失败的)）
     *      创建实例-需要data
     *      更新实例-需要data
     *      启/停实例
     *      删除实例
     *      删除实例存储
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<InstanceExpect.InstanceExpectResponse> getExpectData(
        InstanceExpect.InstanceExpectRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetExpectDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_EXPECT_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExpectImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExpectImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_EXPECT_DATA:
          serviceImpl.getExpectData((InstanceExpect.InstanceExpectRequest) request,
              (io.grpc.stub.StreamObserver<InstanceExpect.InstanceExpectResponse>) responseObserver);
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

  private static abstract class ExpectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExpectBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return InstanceExpect.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Expect");
    }
  }

  private static final class ExpectFileDescriptorSupplier
      extends ExpectBaseDescriptorSupplier {
    ExpectFileDescriptorSupplier() {}
  }

  private static final class ExpectMethodDescriptorSupplier
      extends ExpectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExpectMethodDescriptorSupplier(String methodName) {
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
      synchronized (ExpectGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExpectFileDescriptorSupplier())
              .addMethod(getGetExpectDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
