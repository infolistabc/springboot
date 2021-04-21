package com.sun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.entity.UserDemo;
import com.sun.lib.grpc.user.dto.AddUserRequest;
import com.sun.lib.grpc.user.dto.SearchUserRequest;
import com.sun.lib.grpc.user.dto.UserList;
import com.sun.lib.grpc.user.dto.UserResponse;
import com.sun.lib.grpc.user.service.UserGrpc;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class GrpcUserController {

    @GrpcClient("userClient")
    UserGrpc.UserBlockingStub blockingStub;
    @GrpcClient("userClient")
    UserGrpc.UserStub userStub;

    UserGrpc.UserFutureStub futureStub;
    @PostMapping("/add")
    public String add(@RequestBody UserDemo userDemo) {
        //构造grpc的请求体对象
        AddUserRequest request = AddUserRequest.newBuilder().setAddress(userDemo.getAddress()).setAge(userDemo.getAge()).setName(userDemo.getName()).build();
        UserResponse response;
        try {
            response = blockingStub.add(request);
        } catch (StatusRuntimeException e) {
            log.error("RPC failed: " + e.getMessage(), e);
            throw e;
        }
        log.info("结果"+response);
        return JSONObject.toJSONString(response.getName());
    }

    @GetMapping("/list")
    public List getUserList(@RequestParam("name") String name){
        List<UserDemo> result = new ArrayList<>();
        SearchUserRequest request = SearchUserRequest.newBuilder().setName(name).build();
        Iterator<UserResponse> response;
        try {
            response = blockingStub.list(request);
        } catch (StatusRuntimeException e) {
            log.error("RPC failed: " + e.getMessage(), e);
            throw e;
        }
        while (response.hasNext()) {
            UserResponse userResponse = response.next();
            UserDemo userDemo = new UserDemo();
            userDemo.setId(userResponse.getId());
            userDemo.setName(userResponse.getName());
            userDemo.setAge(userResponse.getAge());
            userDemo.setAddress(userResponse.getAddress());
            result.add(userDemo);
        }
        return result;
    }

    @GetMapping("list1")
    public void getUserList1(@RequestParam("name") String name) {

        StreamObserver<UserList> userList = new StreamObserver<UserList>() {
            /**
             * 每当服务端响应的时候，会回调该方法一次
             *
             * @param userList
             */
            @Override
            public void onNext(UserList userList) {
                userList.getUserResponseList().forEach(userResponse -> {
                    log.info("返回结果{}", userResponse);
                });
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("list1 StreamObserver onError：" + throwable.getMessage(), throwable);
            }

            @Override
            public void onCompleted() {
                //this.onCompleted();
            }
        };
        //向服务端发送异步请求
        StreamObserver<SearchUserRequest> searchUserRequestStreamObserver = userStub.list1(userList);

        //构造传递给服务端的参数，流式发送给服务端
        searchUserRequestStreamObserver.onNext(SearchUserRequest.newBuilder().setName(name).build());
        searchUserRequestStreamObserver.onNext(SearchUserRequest.newBuilder().setName(name).build());
        searchUserRequestStreamObserver.onCompleted();
    }

    @PostMapping("/addBath")
    public void addBatch(){
         StreamObserver<AddUserRequest> addUserRequestStreamObserver = userStub.addBatch(new StreamObserver<UserResponse>() {
            /**
             * 接收服务端的流消息
             * @param userResponse
             */
            @Override
            public void onNext(UserResponse userResponse) {
                System.out.println(userResponse);
                //处理业务
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("addBatch StreamObserver onError："+throwable.getMessage(), throwable);
            }

            @Override
            public void onCompleted() {

            }
        });
        //StreamObserver<AddUserRequest> addUserRequestStreamObserver = userStub.addBatch(responseObserver);
        //模拟发送数据给服务端
        for (int i = 0; i < 5; i++) {
            addUserRequestStreamObserver.onNext(AddUserRequest.newBuilder()
                    .setAge(1)
                    .setAddress("address"+i)
                    .setName("name"+i)
                    .build());
        }

        addUserRequestStreamObserver.onCompleted();
    }
}