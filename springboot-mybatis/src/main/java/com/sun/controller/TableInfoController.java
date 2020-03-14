package com.sun.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wilson
 */
@RestController
@RequestMapping("table")
public class TableInfoController {
    private ITableInfoService iTableInfoService;

    @GetMapping("list")
    public List<TableInfo> getAllTableInfo(){
        return iTableInfoService.getTableInfo();
    }

}
