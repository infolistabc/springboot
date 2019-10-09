package com.sun.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.annotation.UserLoginToken;
import com.sun.entity.User;
import com.sun.service.IUserService;
import com.sun.service.impl.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author qsl
 * @date 2018-07-08 20:45
 */
@RestController
@RequestMapping("api")
public class UserController {
	@Autowired
    IUserService userService;
    @Autowired
    TokenService tokenService;
    /**
     * 登录
     * @param user
     * @return
     */
    @RequestMapping("/login")
    public Object login(User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userService.getUserByName(user.getName());
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
