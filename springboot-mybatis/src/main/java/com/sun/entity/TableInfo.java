package com.sun.vo;

import lombok.Data;

/**
 * @author wilson
 */
@Data
public class TableInfo {
   private Integer id;
   private String column_name;
   private String column_type;
   private String is_nullable;
   private String column_default;
   private String column_key;
   private String column_comment;
}
