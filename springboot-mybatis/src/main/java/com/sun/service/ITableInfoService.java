package com.sun.service;

import java.util.List;

/**
 * @author wilson
 */
public interface ITableInfoService {
	/**
	 * 查询数据库所有表的基本信息
	 * @return
	 */
	List<TableInfo> getTableInfo();

}
