package com.sun.controller;

import com.sun.service.IUserSignService;
import com.sun.vo.SignReqParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity doSign(@RequestBody SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        // doSign
        boolean signed = iUserSignService.doSign(signReqParam.getUid(),today);
        if (signed) {
            return new ResponseEntity("签到成功!", HttpStatus.OK);
        } else {
            return new ResponseEntity("您已签到!", HttpStatus.OK);
        }
    }

    @ApiOperation("当月签到的次数")
    @GetMapping("/getSignCount")
    public ResponseEntity getSignCount(SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        int count = iUserSignService.getSignDays(signReqParam.getUid(),today);
        return new ResponseEntity("本月签到次数："+count,HttpStatus.OK);
    }

    @ApiOperation("检查是否签到")
    @GetMapping("/checkSign")
    public ResponseEntity checkSign(SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        boolean signed = iUserSignService.checkSign(signReqParam.getUid(),today);
        if (signed) {
            return new ResponseEntity("您已签到："+signed,HttpStatus.OK);
        } else {
            return new ResponseEntity("您位签到："+signed,HttpStatus.OK);
        }
    }

    @ApiOperation("查询当月第一次签到的日期")
    @GetMapping("getFirstSignDate")
    public ResponseEntity getFirstSignDate(SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        LocalDate date1 = iUserSignService.getFirstSignDate(signReqParam.getUid(),today);
        return new ResponseEntity("本月首次签到：" + date1,HttpStatus.OK);
    }

    @ApiOperation("获取当月签到详情")
    @GetMapping("/getSignInfo")
    public ResponseEntity getSignInfo(SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        Map<String, Boolean> signInfo = new TreeMap<>(iUserSignService.getSignInfo(signReqParam.getUid(), today));
        return new ResponseEntity(signInfo,HttpStatus.OK);
    }

    @ApiOperation("查询当月连续签到的次数")
    @GetMapping("/getContinuousSignCount")
    public ResponseEntity getContinuousSignCount(SignReqParam signReqParam){
        LocalDate today = formatDate(signReqParam.getDate());
        Long count = iUserSignService.getContinuousSignCount(signReqParam.getUid(),today);
        return new ResponseEntity("当月连续签到的次数"+count,HttpStatus.OK);
    }

    public ResponseEntity delSign(SignReqParam signReqParam){

        return new ResponseEntity("删除成功！",HttpStatus.OK);
    }

    private LocalDate formatDate(String date){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date, fmt);
        return date1;
    }

}
