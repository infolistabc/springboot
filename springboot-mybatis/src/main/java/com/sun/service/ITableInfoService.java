package com.sun.service;

import java.util.List;
import java.util.Map;

/**
 * @author wilson
 */
public interface ITableInfoService {
	/**
	 * 查询数据库表信息
	 * @param dataBase 数据库名称
	 * @return
	 */
	List<Map> listAllTableInfo(String dataBase);

	/**
	 * 根据表名查询数据库表信息
	 * @param dataBase 数据库名称
	 * @param tableName  表名
	 * @return
	 */
	List<Map> listTableColumn(String dataBase, String tableName);

}
