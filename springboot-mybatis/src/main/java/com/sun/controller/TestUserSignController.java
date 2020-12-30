package com.sun.controller;

import com.sun.service.IUserSignService;
import com.sun.vo.SignReqParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/sign")
public class TestUserSignController {
    @Resource
    IUserSignService iUserSignService;

    @ApiOperation("签到")
    @PostMapping("/sign")
    public String doSign(@RequestBody SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        // doSign
        boolean signed = iUserSignService.doSign(signReqParam.getUid(),today);
        if (signed) {
            return "签到完成：" + today;
        } else {
            return "您已签到：" + today;
        }
    }

    @ApiOperation("当月签到的次数")
    @GetMapping("/getSignCount")
    public String getSignCount(SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        int count = iUserSignService.getSignDays(signReqParam.getUid(),today);
        return "本月签到次数：" + count;
    }

    @ApiOperation("检查是否签到")
    @GetMapping("/checkSign")
    public String checkSign(SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        //boolean signed = iUserSignService.checkSign(buildSignKey(1000,today),today.getDayOfMonth()+1);
        boolean signed = iUserSignService.checkSign(signReqParam.getUid(),today);
        if (signed) {
            return "您已签到：" + today;
        } else {
            return "尚未签到：" + today;
        }
    }

    @ApiOperation("查询当月第一次签到的日期")
    @GetMapping("getFirstSignDate")
    public String getFirstSignDate(SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        LocalDate date1 = iUserSignService.getFirstSignDate(signReqParam.getUid(),today);
        return "本月首次签到：" + date1;
    }

    @ApiOperation("获取当月签到详情")
    @GetMapping("/getSignInfo")
    public Map getSignInfo(SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        Map<String, Boolean> signInfo = new TreeMap<>(iUserSignService.getSignInfo(signReqParam.getUid(), today));
        return signInfo;
    }

    @ApiOperation("查询当月连续签到的次数")
    @GetMapping("/getContinuousSignCount")
    public Long getContinuousSignCount(SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        return iUserSignService.getContinuousSignCount(signReqParam.getUid(),today);
    }

    private LocalDate formatDate(String date){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date, fmt);
        return date1;
    }

}
