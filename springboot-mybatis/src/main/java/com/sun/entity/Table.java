package com.sun.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wilson
 */
@Data
public class Table implements Serializable {
   @ExcelProperty(value = "序号",index = 0)
   private Integer index;
   @ExcelProperty(value = "字段名称",index = 1)
   private String columnName;
   @ExcelProperty(value = "类型（取值）",index = 2)
   private String columnType;
   @ExcelProperty(value = "是否为空",index = 3)
   private String isNullable;
   @ExcelProperty(value = "默认",index = 4)
   private String columnDefault;
   @ExcelProperty(value = "主键",index = 5)
   private String columnKey;
   @ExcelProperty(value = "字段描述",index = 6)
   private String columnComment;
   @ExcelProperty(value = "表名",index = 7)
   private String tableName;
}
