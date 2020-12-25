package com.sun.controller;


import com.sun.util.UserOnlineUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 测试用户上线，下线功能
 */
@Api(tags = "测试用户上线，下线功能")
@RestController
public class TestUserOnlineController {
    @Resource
    UserOnlineUtil userOnlineUtil;

    @PostMapping("/doOnline")
    public String doOnline(){
        LocalDate today = LocalDate.now();
        // doSign
        boolean signed = userOnlineUtil.doOnline(today,100L);
        userOnlineUtil.doOnline(today,102L);
        userOnlineUtil.doOnline(today,103L);
        if (signed) {
            return "您已上线：" + formatDate(today, "yyyy-MM-dd");
        } else {
            return "上报成功：" + formatDate(today, "yyyy-MM-dd");
        }
    }

    @PostMapping("/doUnderLine")
    public String doUnderLine(){
        LocalDate today = LocalDate.now();
        // doSign
        boolean signed = userOnlineUtil.doUnderLine(today,100L);
        if (signed) {
            return "您已下线：" + formatDate(today, "yyyy-MM-dd");
        } else {
            return "下线成功：" + formatDate(today, "yyyy-MM-dd");
        }
    }

    @GetMapping("/geOnlineTodayCount")
    public String geOnlineTodayCount(){
        LocalDate today = LocalDate.now();
        long count = userOnlineUtil.geOnlineTodayCount(today);
        return "当天上报次数：" + count;
    }

    @GetMapping("/getOnlineWeekCount")
    public String getOnlineWeekCount(){
        LocalDate today = LocalDate.now();
        long count = userOnlineUtil.getOnlineWeekCount(today);
        return "当天时间的前7天上报次数："+count;
    }

    private static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}
