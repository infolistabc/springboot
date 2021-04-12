package com.sun.lib.grpc.user.service;

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
 *服务定义
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.31.1)",
    comments = "Source: user_service.proto")
public final class UserGrpc {

  private UserGrpc() {}

  public static final String SERVICE_NAME = "com.sun.lib.grpc.user.dto.User";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.sun.lib.grpc.user.dto.SearchUserRequest,
      com.sun.lib.grpc.user.dto.UserResponse> getListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "list",
      requestType = com.sun.lib.grpc.user.dto.SearchUserRequest.class,
      responseType = com.sun.lib.grpc.user.dto.UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.sun.lib.grpc.user.dto.SearchUserRequest,
      com.sun.lib.grpc.user.dto.UserResponse> getListMethod() {
    io.grpc.MethodDescriptor<com.sun.lib.grpc.user.dto.SearchUserRequest, com.sun.lib.grpc.user.dto.UserResponse> getListMethod;
    if ((getListMethod = UserGrpc.getListMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getListMethod = UserGrpc.getListMethod) == null) {
          UserGrpc.getListMethod = getListMethod =
              io.grpc.MethodDescriptor.<com.sun.lib.grpc.user.dto.SearchUserRequest, com.sun.lib.grpc.user.dto.UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "list"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sun.lib.grpc.user.dto.SearchUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sun.lib.grpc.user.dto.UserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserMethodDescriptorSupplier("list"))
              .build();
        }
      }
    }
    return getListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sun.lib.grpc.user.dto.AddUserRequest,
      com.sun.lib.grpc.user.dto.UserResponse> getAddMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "add",
      requestType = com.sun.lib.grpc.user.dto.AddUserRequest.class,
      responseType = com.sun.lib.grpc.user.dto.UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sun.lib.grpc.user.dto.AddUserRequest,
      com.sun.lib.grpc.user.dto.UserResponse> getAddMethod() {
    io.grpc.MethodDescriptor<com.sun.lib.grpc.user.dto.AddUserRequest, com.sun.lib.grpc.user.dto.UserResponse> getAddMethod;
    if ((getAddMethod = UserGrpc.getAddMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getAddMethod = UserGrpc.getAddMethod) == null) {
          UserGrpc.getAddMethod = getAddMethod =
              io.grpc.MethodDescriptor.<com.sun.lib.grpc.user.dto.AddUserRequest, com.sun.lib.grpc.user.dto.UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "add"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sun.lib.grpc.user.dto.AddUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sun.lib.grpc.user.dto.UserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserMethodDescriptorSupplier("add"))
              .build();
        }
      }
    }
    return getAddMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.sun.lib.grpc.user.dto.AddUserRequest,
      com.sun.lib.grpc.user.dto.UserResponse> getAddBatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addBatch",
      requestType = com.sun.lib.grpc.user.dto.AddUserRequest.class,
      responseType = com.sun.lib.grpc.user.dto.UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.sun.lib.grpc.user.dto.AddUserRequest,
      com.sun.lib.grpc.user.dto.UserResponse> getAddBatchMethod() {
    io.grpc.MethodDescriptor<com.sun.lib.grpc.user.dto.AddUserRequest, com.sun.lib.grpc.user.dto.UserResponse> getAddBatchMethod;
    if ((getAddBatchMethod = UserGrpc.getAddBatchMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getAddBatchMethod = UserGrpc.getAddBatchMethod) == null) {
          UserGrpc.getAddBatchMethod = getAddBatchMethod =
              io.grpc.MethodDescriptor.<com.sun.lib.grpc.user.dto.AddUserRequest, com.sun.lib.grpc.user.dto.UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addBatch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sun.lib.grpc.user.dto.AddUserRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sun.lib.grpc.user.dto.UserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserMethodDescriptorSupplier("addBatch"))
              .build();
        }
      }
    }
    return getAddBatchMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserStub>() {
        @java.lang.Override
        public UserStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserStub(channel, callOptions);
        }
      };
    return UserStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserBlockingStub>() {
        @java.lang.Override
        public UserBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserBlockingStub(channel, callOptions);
        }
      };
    return UserBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserFutureStub>() {
        @java.lang.Override
        public UserFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserFutureStub(channel, callOptions);
        }
      };
    return UserFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   *服务定义
   * </pre>
   */
  public static abstract class UserImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *查询用户列表，以流式返回多个对象
     * </pre>
     */
    public void list(com.sun.lib.grpc.user.dto.SearchUserRequest request,
        io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.UserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListMethod(), responseObserver);
    }

    /**
     * <pre>
     *添加用户信息，返回单个对象
     * </pre>
     */
    public void add(com.sun.lib.grpc.user.dto.AddUserRequest request,
        io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.UserResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAddMethod(), responseObserver);
    }

    /**
     * <pre>
     *批量添加用户
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.AddUserRequest> addBatch(
        io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.UserResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getAddBatchMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.sun.lib.grpc.user.dto.SearchUserRequest,
                com.sun.lib.grpc.user.dto.UserResponse>(
                  this, METHODID_LIST)))
          .addMethod(
            getAddMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.sun.lib.grpc.user.dto.AddUserRequest,
                com.sun.lib.grpc.user.dto.UserResponse>(
                  this, METHODID_ADD)))
          .addMethod(
            getAddBatchMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.sun.lib.grpc.user.dto.AddUserRequest,
                com.sun.lib.grpc.user.dto.UserResponse>(
                  this, METHODID_ADD_BATCH)))
          .build();
    }
  }

  /**
   * <pre>
   *服务定义
   * </pre>
   */
  public static final class UserStub extends io.grpc.stub.AbstractAsyncStub<UserStub> {
    private UserStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserStub(channel, callOptions);
    }

    /**
     * <pre>
     *查询用户列表，以流式返回多个对象
     * </pre>
     */
    public void list(com.sun.lib.grpc.user.dto.SearchUserRequest request,
        io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.UserResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *添加用户信息，返回单个对象
     * </pre>
     */
    public void add(com.sun.lib.grpc.user.dto.AddUserRequest request,
        io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.UserResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *批量添加用户
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.AddUserRequest> addBatch(
        io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.UserResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getAddBatchMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *服务定义
   * </pre>
   */
  public static final class UserBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserBlockingStub> {
    private UserBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *查询用户列表，以流式返回多个对象
     * </pre>
     */
    public java.util.Iterator<com.sun.lib.grpc.user.dto.UserResponse> list(
        com.sun.lib.grpc.user.dto.SearchUserRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *添加用户信息，返回单个对象
     * </pre>
     */
    public com.sun.lib.grpc.user.dto.UserResponse add(com.sun.lib.grpc.user.dto.AddUserRequest request) {
      return blockingUnaryCall(
          getChannel(), getAddMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *服务定义
   * </pre>
   */
  public static final class UserFutureStub extends io.grpc.stub.AbstractFutureStub<UserFutureStub> {
    private UserFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *添加用户信息，返回单个对象
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sun.lib.grpc.user.dto.UserResponse> add(
        com.sun.lib.grpc.user.dto.AddUserRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAddMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST = 0;
  private static final int METHODID_ADD = 1;
  private static final int METHODID_ADD_BATCH = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST:
          serviceImpl.list((com.sun.lib.grpc.user.dto.SearchUserRequest) request,
              (io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.UserResponse>) responseObserver);
          break;
        case METHODID_ADD:
          serviceImpl.add((com.sun.lib.grpc.user.dto.AddUserRequest) request,
              (io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.UserResponse>) responseObserver);
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
        case METHODID_ADD_BATCH:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addBatch(
              (io.grpc.stub.StreamObserver<com.sun.lib.grpc.user.dto.UserResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.sun.lib.grpc.user.service.UserProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("User");
    }
  }

  private static final class UserFileDescriptorSupplier
      extends UserBaseDescriptorSupplier {
    UserFileDescriptorSupplier() {}
  }

  private static final class UserMethodDescriptorSupplier
      extends UserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserFileDescriptorSupplier())
              .addMethod(getListMethod())
              .addMethod(getAddMethod())
              .addMethod(getAddBatchMethod())
              .build();
        }
      }
    }
    return result;
  }
}
