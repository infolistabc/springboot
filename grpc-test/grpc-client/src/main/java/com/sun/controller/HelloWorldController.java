package com.sun.controller;

import com.alibaba.fastjson.JSONObject;
import grpc_code.greeter.GreeterGrpc;
import grpc_code.greeter.Hellowold;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Iterator;

@RestController
@Slf4j
public class HelloWorldController {
    @GrpcClient("userClient")
    private GreeterGrpc.GreeterBlockingStub greeterBlockingStub;

    @GetMapping("/sayHello")
    public String sayHelloWord(String name){
        log.info("开始hello Grpc");
        Hellowold.HelloRequest request = Hellowold.HelloRequest.newBuilder().setName(name).build();
        Hellowold.HelloReply helloReply = null;
        try {
            helloReply = greeterBlockingStub.sayHello(request);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        log.info("testAdd结果: " + helloReply.getMessage());
        return JSONObject.toJSONString(helloReply.getMessage());
    }

    @GetMapping("/lotsOfReplies")
    public void lotsOfReplies(String name){
        log.info("开始lotsOfReplies");
        Hellowold.HelloRequest request = Hellowold.HelloRequest.newBuilder().setName(name).build();
        Iterator<Hellowold.HelloReply> response;
        try {
            response = greeterBlockingStub.lotsOfReplies(request);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        while (response.hasNext()) {
            log.info("test结果"+response.next());
        }
    }
}
