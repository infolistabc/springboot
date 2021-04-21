package com.sun.service.impl;

import javax.annotation.Resource;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sun.entity.UserDemo;
import com.sun.lib.grpc.user.dto.AddUserRequest;
import com.sun.lib.grpc.user.dto.SearchUserRequest;
import com.sun.lib.grpc.user.dto.UserList;
import com.sun.lib.grpc.user.dto.UserResponse;
import com.sun.lib.grpc.user.service.UserGrpc;
import com.sun.mapper.UserDemoMapper;
import io.grpc.stub.StreamObserver;
import org.springframework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;
import java.util.ArrayList;
import java.util.List;

import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

@GrpcService
@Slf4j
public class UserServiceGrpcImpl extends UserGrpc.UserImplBase {

    @Resource
    UserDemoMapper userDemoMapper;

    /**
     * 添加用户信息rpc接口
     * @param request rpc接口请求参数
     * @param responseObserver rpc流式响应
     */
    @Override
    public void add(AddUserRequest request, StreamObserver<UserResponse> responseObserver) {
        UserDemo ud = new UserDemo();
        ud.setName(request.getName());
        ud.setAge(request.getAge());
        ud.setAddress(request.getAddress());
        userDemoMapper.insert(ud);

        //构造rpc响应参数
        UserResponse reply = UserResponse.newBuilder().setId(ud.getId()).setName(request.getName()).setAge(ud.getAge())
            .setAddress(ud.getAddress()).build();
        //发送响应数据
        responseObserver.onNext(reply);
        //关闭通道
        responseObserver.onCompleted();
    }

    /**
     * 查询用户列表
     * @param request rpc接口请求参数
     * @param responseObserver rpc流式响应，返回多个消息
     */
    @Override
    public void list(SearchUserRequest request, StreamObserver<UserResponse> responseObserver) {

        LambdaQueryWrapper<UserDemo> lq = new LambdaQueryWrapper<UserDemo>();
        if(StringUtils.hasText(request.getName())) {
            lq.eq(UserDemo::getName, request.getName());
        }
        List<UserDemo> list = userDemoMapper.selectList(lq);
        list.stream().forEach(c -> {
            UserResponse ur = UserResponse.newBuilder().setAddress(c.getAddress()).setAge(c.getAge()).setId(c.getId())
                .setName(c.getName()).build();
            responseObserver.onNext(ur);
        });
        responseObserver.onCompleted();
    }

    /**
     * 查询用户列表
     * @param responseObserver 返回多个实体对象
     * @return
     */
    public StreamObserver<SearchUserRequest> list1(StreamObserver<UserList> responseObserver) {
        return new StreamObserver<SearchUserRequest>() {
            UserList.Builder userListBuilder = UserList.newBuilder();
            /**
             * 当客户端流式请求发送的时候，每发送一个StudentRequest，该方法将会被回调一次
             * @param searchUserRequest
             */
            @Override
            public void onNext(SearchUserRequest searchUserRequest) {
                //查询数据库
                LambdaQueryWrapper<UserDemo> lq = new LambdaQueryWrapper<UserDemo>();
                if(StringUtils.hasText(searchUserRequest.getName())) {
                    lq.eq(UserDemo::getName, searchUserRequest.getName());
                }
                List<UserDemo> list = userDemoMapper.selectList(lq);
                //构造grpc返回参数
                list.stream().forEach(c -> {
                    UserResponse.Builder userBuilder = UserResponse.newBuilder()
                            .setAddress(c.getAddress())
                            .setAge(c.getAge())
                            .setId(c.getId())
                            .setName(c.getName());
                    userListBuilder.addUserResponse(userBuilder.build());
                });
            }

            @Override
            public void onError(Throwable throwable) {
                log.info("list StreamObserver onError："+throwable.getMessage(), throwable);
            }
            //
            @Override
            public void onCompleted() {
                responseObserver.onNext(userListBuilder.build());
                responseObserver.onCompleted();
            }
        };
    }

    /**
     * 批量添加用户
     * @param responseObserver rpc流式响应，返回多个消息
     * @return
     */
    @Override
    public StreamObserver<AddUserRequest> addBatch(StreamObserver<UserResponse> responseObserver) {
        return new StreamObserver<AddUserRequest>() {

            /**
             * 功能描述: 当客户端流式请求发送的时候，每发送一个AddUserRequest，该方法将会被回调一次
             * @param value
             */
            @Override
            public void onNext(AddUserRequest value) {
                UserDemo userDemoEntity = new UserDemo();
                userDemoEntity.setName(value.getName());
                userDemoEntity.setAge(value.getAge());
                userDemoEntity.setAddress(value.getAddress());
                userDemoMapper.insert(userDemoEntity);

                UserResponse ur =
                    UserResponse.newBuilder().setAddress(userDemoEntity.getAddress()).setAge(userDemoEntity.getAge())
                        .setId(userDemoEntity.getId()).build();
                responseObserver.onNext(ur);
            }

            /**
             * 功能描述: 虽然客户端和服务端互相传递数据的流是独立的，但是正常业务场景情况下客户端的流完毕后，服务端也是关闭,
             * 所以在这里当客户端的请求流关闭后，也关闭流
             */
            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }

            @Override
            public void onError(Throwable t) {
                log.info("addBatch StreamObserver onError："+t.getMessage(), t);
            }
        };
    }
}