package com.sun.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wilson
 */
@Data
public class TableInfo implements Serializable {
   private String COLUMN_NAME;
   private String COLUMN_TYPE;
   private String COLUMN_KEY;
   private String IS_NULLABLE;
   private String COLUMN_COMMENT;

   private String TABLE_NAME;
}
