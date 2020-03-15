package com.sun.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * 学生实体类
 * @author shixiangcheng
 * 2020-01-17
 */
@Data
public class Student {
	@ExcelProperty({"学号"})
	private String no;
	@ExcelProperty({"姓名"})
	private String name;
	@ExcelProperty({"生日"})
	private String birthday;
}
