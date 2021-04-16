package com.sun.lib.grpc;

import com.sun.lib.grpc.vo.AddUser;

public class TestClass {
    public static void main(String[] args) {
        //创建一个对象
        AddUser.Builder addUser = AddUser.newBuilder();
        addUser.setName("张三");
        addUser.setAge(12);
        addUser.addPhone("11111");
        addUser.addPhone("22222");
        addUser.setAddress("测试地址");
        addUser.build();
        System.out.printf("输出\n"+addUser.build());
    }
}
