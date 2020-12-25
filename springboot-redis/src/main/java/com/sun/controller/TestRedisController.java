package com.sun.controller;

import com.sun.util.RedisUtil;
import com.sun.vo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试String存储和Hash存储的基本应用
 */
@Api(tags = "redis测试接口")
@RestController
@RequestMapping("/user")
public class TestRedisController {
    @Resource
    RedisUtil redisUtil;

    @ApiOperation("使用redis的String数据存储用户信息")
    @PostMapping
    public ResponseEntity addUser(){
        User user = new User();
        user.setId(1L);
        user.setUsername("张三");
        user.setPassword("1234");
        user.setEmail("test@qq.com");
        user.setPhone("15820106290");
        redisUtil.set("user:info:"+user.getId(),user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation("查询用户信息")
    @GetMapping
    public ResponseEntity getUserById(){
        User user = (User) redisUtil.get("user:info:"+1);
        return new ResponseEntity(user,HttpStatus.OK);
    }

    @ApiOperation("用hash的数据库结构存储用户信息")
    @PostMapping("/addHashUser")
    public ResponseEntity addHashUser(){
        User user = new User();
        user.setId(2L);
        user.setUsername("张三");
        user.setPassword("1234");
        user.setEmail("test@qq.com");
        user.setPhone("15820106290");
//        redisUtil.hPut("user:info:"+user.getId(),"id",user.getId());
//        redisUtil.hPut("user:info:"+user.getId(),"username",user.getUsername());
//        redisUtil.hPut("user:info:"+user.getId(),"phone",user.getPhone());
        Map<String,Object> map = new HashMap<>();
        map.put("id", user.getId());
        map.put("username", user.getUsername());
        map.put("phone", user.getPhone());
        redisUtil.hPutAll("user:info:"+user.getId(),map);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ApiOperation("用hash的数据库结构存储用户信息")
    @PostMapping("/getHashUser")
    public ResponseEntity getHashUser(){
        Map map = redisUtil.hGetAll("user:info:2");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @ApiOperation("用hash的数据库结构存储用户信息")
    @PostMapping("/getUserName")
    public ResponseEntity getUserName(){
        Object phone = redisUtil.hGet("user:info:2","username");
        return new ResponseEntity(phone,HttpStatus.OK);
    }

    @ApiOperation("用hash的数据库结构存储用户信息")
    @PutMapping("/updateName")
    public ResponseEntity updateName(){
        redisUtil.hPut("user:info:2","username","李四");
        return new ResponseEntity(HttpStatus.OK);
    }
}
