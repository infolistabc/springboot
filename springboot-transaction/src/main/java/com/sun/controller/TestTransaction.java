package com.sun.controller;

import com.sun.service.IOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("test")
public class TestTransaction {
    @Resource
    IOrderService iOrderService;
    @PostMapping
    public void addOrder()throws Exception{
        iOrderService.addOrder();
    }
}
