package com.sun.controller;


import com.sun.util.UserDau;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 测试签到功能
 */
@RestController
public class TestUserDauController {
    @Resource
    UserDau userDau;

    @PostMapping("/dauLogin")
    public String dauLogin(){
        LocalDate today = LocalDate.now();
        // doSign
        boolean signed = userDau.doLogin(today,100L);
        boolean signed1 = userDau.doLogin(today,101L);
        userDau.doLogin(today,102L);
        userDau.doLogin(today,103L);
        userDau.doLogin(today,103L);
        if (signed1) {
            return "您已上报：" + formatDate(today, "yyyy-MM-dd");
        } else {
            return "上报成功：" + formatDate(today, "yyyy-MM-dd");
        }
    }

    @GetMapping("/getDauCount")
    public String getDauCount(){
        LocalDate today = LocalDate.now();
        long count = userDau.getTodayCount(today);
        return "当天签到次数：" + count;
    }

    @GetMapping("/getWeekCount")
    public String getWeekCount(){
        LocalDate today = LocalDate.now();
        long count = userDau.getWeekCount(today);
        return "";
    }

    private static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}
