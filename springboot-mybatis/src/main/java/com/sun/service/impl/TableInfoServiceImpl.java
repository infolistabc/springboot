package com.sun.service.impl;

import com.sun.dao.ITableInfoDao;
import com.sun.service.ITableInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wilson
 */
@Service
public class TableInfoServiceImpl implements ITableInfoService {
	@Resource
	private ITableInfoDao iTableInfoDao;


	@Override
	public List<TableInfo> getTableInfo() {
		return iTableInfoDao.getTableInfo();
	}
}
