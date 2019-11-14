package com.sun.dao;

import java.util.List;

import com.sun.entity.Demo;
import com.sun.entity.User;
/**
 * 
 * @author wilson
 * @date 2019-0724
 */
public interface IDemoDao {
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int batchInsert(List<Demo> demo);
}
