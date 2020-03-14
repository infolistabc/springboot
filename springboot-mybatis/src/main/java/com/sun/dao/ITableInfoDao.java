package com.sun.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author wilson
 */
public interface ITableInfoDao {
    /**
     * 查询数据库表信息
     * @param dataBase 数据库名称
     * @return
     */
    @Select("select table_name,column_name,column_type,is_nullable,column_default,column_key,column_comment " +
            "from information_schema.COLUMNS WHERE TABLE_schema=#{dataBase}")
    List<Map> listAllTableInfo(String dataBase);

    /**
     * 根据表名查询数据库表信息
     * @param dataBase 数据库名称
     * @param tableName  表名
     * @return
     */
    @Select("select table_name,column_name,column_type,is_nullable,column_default,column_key,column_comment from information_schema.COLUMNS where TABLE_SCHEMA = (select database()) and TABLE_NAME=#{tableName}")
    List<Map> listTableColumn(@Param("dataBase") String dataBase, @Param("tableName") String tableName);
}
