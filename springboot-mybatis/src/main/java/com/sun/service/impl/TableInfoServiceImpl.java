package com.sun.service.impl;

import com.sun.dao.ITableInfoDao;
import com.sun.entity.TableInfo;
import com.sun.service.ITableInfoService;
import com.sun.utils.ToBeanUtil;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wilson
 */
@Service
public class TableInfoServiceImpl implements ITableInfoService {
	@Resource
	private ITableInfoDao iTableInfoDao;


	@Override
	public List<Map> listAllTableInfo(String dataBase) {
		return iTableInfoDao.listAllTableInfo(dataBase);
	}

	@Override
	public List<Map> listTableColumn(String dataBase, String tableName) {
		return iTableInfoDao.listTableColumn(dataBase,tableName);
	}


}
