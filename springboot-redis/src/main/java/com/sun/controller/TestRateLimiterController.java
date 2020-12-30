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
    public String setNxRate(HttpServletRequest request) {
        boolean flag = simpleRateLimiterUtil.setNxRate("action:url:" + request.getRequestURI(), 2, 10, TimeUnit.SECONDS);
        if (flag) {
            return "正常访问";
        } else {
            return "频发访问";
        }
    }

    @GetMapping("/setLimitFlow")
    public String setLimitFlow() {
        String key = "setLimitFlow";
        boolean flag = simpleRateLimiterUtil.setLimitFlow(key, 60L);
        if (flag) {
            return "正常访问";
        } else {
            return "频发访问";
        }
    }

    @GetMapping("/redisCell")
    public String redisCell() {
        // 接口API
        String key = "/user/list";
        // 漏斗初始容量
        int capacity = 5;
        // 单位时间内允许访问的频率
        int rate = 8;
        // 单位时间(秒)，即每秒允许有8次访问
        int seconds = 1;
        // 每次请求漏斗容量减少的数量
        int tocken_num = 1;
        for (int i = 0; i < 10; i++) {
            boolean allow = simpleRateLimiterUtil.throttle(key, capacity, rate, seconds, tocken_num);
            if (allow) {
                System.out.println("正常执行请求:" + i);
            } else {
                System.out.println("被限流了:" + i);
            }
        }
        return "";
    }
}
