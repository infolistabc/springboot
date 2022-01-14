package com.sun.es.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiansl
 * @version 1.0
 * @date 2021/12/27 11:30 上午
 * @description
 */
@RestController
public class EsController {

    @GetMapping("test")
   public String test(){
       return "测试";
   }
}
