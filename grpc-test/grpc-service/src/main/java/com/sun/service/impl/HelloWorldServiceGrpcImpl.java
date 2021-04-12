package com.sun.service.impl;

import grpc_code.greeter.GreeterGrpc;
import grpc_code.greeter.Hellowold;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;


@GrpcService
@Slf4j
public class HelloWorldServiceGrpcImpl extends GreeterGrpc.GreeterImplBase {

    /**
     * <pre>
     * 接口声明, 类似http 的一来一回短消息
     * </pre>
     */
    @Override
    public void sayHello(Hellowold.HelloRequest request, StreamObserver<Hellowold.HelloReply> responseObserver) {
        log.info("test sayHello");
        //构造rpc返回参数
        Hellowold.HelloReply helloReply = Hellowold.HelloReply.newBuilder().setMessage(request.getName()).build();
        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
        log.info("test sayHello end");
    }

    /**
     * <pre>
     * server stream    client端短连接 server端长连接
     * </pre>
     */
    @Override
    public void lotsOfReplies(Hellowold.HelloRequest request, StreamObserver<Hellowold.HelloReply> responseObserver) {
        log.info("test lotsOfReplies");
        Hellowold.HelloReply reply = Hellowold.HelloReply.newBuilder().setMessage(request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
        log.info("test lotsOfReplies end");
    }

//    /**
//     * <pre>
//     * client stream    server端短连接 client端长连接
//     * </pre>
//     */
//    @Override
//    public io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloRequest1> lotsOfGreetings(
//            io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply> responseObserver) {
//
//    }

//    /**
//     * <pre>
//     * Bidirectional streaming      client,server全部长连接
//     * </pre>
//     */
//    public io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloRequest1> bidiHello(
//            io.grpc.stub.StreamObserver<grpc_code.greeter.Hellowold.HelloReply> responseObserver) {
//        return asyncUnimplementedStreamingCall(getBidiHelloMethod(), responseObserver);
//    }
}
