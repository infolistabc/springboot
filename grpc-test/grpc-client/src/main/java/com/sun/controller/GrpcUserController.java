package com.sun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.entity.UserDemo;
import com.sun.lib.grpc.user.dto.AddUserRequest;
import com.sun.lib.grpc.user.dto.SearchUserRequest;
import com.sun.lib.grpc.user.dto.UserResponse;
import com.sun.lib.grpc.user.service.UserGrpc;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@Slf4j
public class GrpcUserController {

    @GrpcClient("userClient")
    private UserGrpc.UserBlockingStub blockingStub;

    @GetMapping("/helloGrpc")
    public String helloGrpc(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.info("开始helloGrpc");
        AddUserRequest request = AddUserRequest.newBuilder().setAddress("深圳").setAge(28).setName("测试").build();
        UserResponse response;
        try {
            response = blockingStub.add(request);
        } catch (StatusRuntimeException e) {
            log.error("RPC failed: " + e.getMessage(), e);
            throw e;
        }
        log.info("testAdd结果: " + response.getName());

        return JSONObject.toJSONString(response.getName());
    }
    @GetMapping("/getUserList")
    public List getUserList(){
        List<UserDemo> result = new ArrayList<>();
        SearchUserRequest request = SearchUserRequest.newBuilder().setName("测试").build();
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
}