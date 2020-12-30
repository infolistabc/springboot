package com.sun.controller;

import com.sun.util.SimpleRateLimiterUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Api(tags = "测试限流接口")
@RestController
@RequestMapping("/reteLimiter")
public class TestRateLimiterController {

    @Resource
    SimpleRateLimiterUtil simpleRateLimiterUtil;

    @GetMapping("/setNxRate")
    public String setNxRate(HttpServletRequest request){
       boolean flag = simpleRateLimiterUtil.setNxRate("action:url:"+request.getRequestURI(),2,10,TimeUnit.SECONDS);
        if (flag){
            return "正常访问";
        }else {
            return "频发访问";
        }
    }

    @GetMapping("/setLimitFlow")
    public String setLimitFlow(){
        String key = "setLimitFlow";
        boolean flag = simpleRateLimiterUtil.setLimitFlow(key,60L);
        if (flag){
            return "正常访问";
        }else {
            return "频发访问";
        }

    }
}
