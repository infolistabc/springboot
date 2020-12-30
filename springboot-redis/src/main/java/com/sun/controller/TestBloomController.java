package com.sun.controller;

import com.sun.filter.BloomFilterHelper;
import com.sun.util.BloomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试String存储和Hash存储的基本应用
 */
@Api(tags = "测试布隆过滤器接口")
@RestController
@RequestMapping("/bloom")
public class TestBloomController {
    @Resource
    BloomUtil bloomUtil;

    @Autowired
    private BloomFilterHelper bloomFilterHelper;

    @PostMapping("/add")
    public void bfAdd(){
        bloomUtil.addByBloomFilter(bloomFilterHelper,"bloom:user","1000");
    }

    @PostMapping("/isExists")
    public String isExists(){
        boolean flag = bloomUtil.includeByBloomFilter(bloomFilterHelper,"bloom:user","1000");
        if (flag) {
            return "存在";
        } else {
            return "不存在";
        }
    }
}
