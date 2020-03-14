package com.sun.dao;

import com.sun.vo.TableInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author wilson
 */
public interface ITableInfoDao extends JpaRepository<TableInfo, Integer> {
    /**
     * 查询数据库所有表的基本信息
     * @return
     */
    @Query(value = "SELECT column_name,column_type," +
            "is_nullable,column_default,column_key," +
            "column_comment from information_schema.COLUMNS " +
            "WHERE TABLE_schema='viid' and table_name='viid_ape'")
    List<TableInfo> getTableInfo();
}
