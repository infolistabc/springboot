package com.sun.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wilson
 */
@Data
public class Table implements Serializable {
   @ExcelProperty(value = "字段名称",index = 0)
   private String COLUMN_NAME;
   @ExcelProperty(value = "字段类型",index = 1)
   private String COLUMN_TYPE;
   @ExcelProperty(value = "索引",index = 2)
   private String COLUMN_KEY;
   @ExcelProperty(value = "是否为空",index = 3)
   private String IS_NULLABLE;
   @ExcelProperty(value = "备注",index = 4)
   private String COLUMN_COMMENT;

   private String TABLE_NAME;
}
