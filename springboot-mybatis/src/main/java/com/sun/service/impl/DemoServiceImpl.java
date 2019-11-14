package com.sun.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sun.dao.IDemoDao;
import com.sun.entity.Demo;
import com.sun.service.IDemoService;
@Service
public class DemoServiceImpl implements IDemoService {
	@Resource
	private IDemoDao iDemoDao;
	@Override
	public boolean batchInsert(List<Demo> demo) {
		return iDemoDao.batchInsert(demo)>0;
	}

	

}
