package com.sun.controller;

import com.sun.util.UserSignUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

/**
 * 测试签到功能
 */
@Api(tags = "测试签到功能")
@RestController
public class TestSignController {
    @Resource
    UserSignUtil userSignUtil;

    @PostMapping("/sign")
    public String sign(){
        LocalDate today = LocalDate.now();
        // doSign
        boolean signed = userSignUtil.doSign(1000, today);
        if (signed) {
            return "您已签到：" + formatDate(today, "yyyy-MM-dd");
        } else {
            return "签到完成：" + formatDate(today, "yyyy-MM-dd");
        }
    }

    @GetMapping("/checkSign")
    public String checkSign(){
        LocalDate today = LocalDate.now();
        boolean signed = userSignUtil.checkSign(1000, today);
        if (signed) {
            return "您已签到：" + formatDate(today, "yyyy-MM-dd");
        } else {
            return "尚未签到：" + formatDate(today, "yyyy-MM-dd");
        }
    }

    @GetMapping("/getSignCount")
    public String getSignCount(){
        LocalDate today = LocalDate.now();
        long count = userSignUtil.getSignCount(1000, today);
        return "本月签到次数：" + count;
    }

    @GetMapping("/getContinuousSignCount")
    public String getContinuousSignCount(){
        LocalDate today = LocalDate.now();
        long count = userSignUtil.getContinuousSignCount(1000, today);
        return "连续签到次数：" + count;
    }

    @GetMapping("getFirstSignDate")
    public String getFirstSignDate(){
        LocalDate today = LocalDate.now();
        LocalDate date = userSignUtil.getFirstSignDate(1000, today);
        return "本月首次签到：" + formatDate(date, "yyyy-MM-dd");
    }

    @GetMapping("/getSignInfo")
    public Map getSignInfo(){
        LocalDate today = LocalDate.now();
        Map<String, Boolean> signInfo = new TreeMap<>(userSignUtil.getSignInfo(1000, today));
        for (Map.Entry<String, Boolean> entry : signInfo.entrySet()) {
            System.out.println(entry.getKey() + ": " + (entry.getValue() ? "√" : "-"));
        }
        return signInfo;
    }

    @GetMapping("/testSign")
    public void testSign(){
        LocalDate today = LocalDate.now();
        { // doSign
            boolean signed = userSignUtil.doSign(1000, today);
            if (signed) {
                System.out.println("您已签到：" + formatDate(today, "yyyy-MM-dd"));
            } else {
                System.out.println("签到完成：" + formatDate(today, "yyyy-MM-dd"));
            }
        }

        { // checkSign
            boolean signed = userSignUtil.checkSign(1000, today);
            if (signed) {
                System.out.println("您已签到：" + formatDate(today, "yyyy-MM-dd"));
            } else {
                System.out.println("尚未签到：" + formatDate(today, "yyyy-MM-dd"));
            }
        }

        { // getSignCount
            long count = userSignUtil.getSignCount(1000, today);
            System.out.println("本月签到次数：" + count);
        }

        { // getContinuousSignCount
            long count = userSignUtil.getContinuousSignCount(1000, today);
            System.out.println("连续签到次数：" + count);
        }

        { // getFirstSignDate
            LocalDate date = userSignUtil.getFirstSignDate(1000, today);
            System.out.println("本月首次签到：" + formatDate(date, "yyyy-MM-dd"));
        }

        { // getSignInfo
            System.out.println("当月签到情况：");
            Map<String, Boolean> signInfo = new TreeMap<>(userSignUtil.getSignInfo(1000, today));
            for (Map.Entry<String, Boolean> entry : signInfo.entrySet()) {
                System.out.println(entry.getKey() + ": " + (entry.getValue() ? "√" : "-"));
            }
        }
    }

    private static String formatDate(LocalDate date, String pattern) {
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }
}
