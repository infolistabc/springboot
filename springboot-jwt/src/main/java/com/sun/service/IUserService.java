package com.sun.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sun.entity.User;
/**
 * 
 * @author wilson
 *
 */
public interface IUserService {
	/**
	 * 新增用户
	 * @param user
	 * @return 添加成功返回true，否则返回false
	 */
	boolean addUser(User user);
	/**
	 * 存在用户编号则更新用户信息，不存在用户编号则新增用户信息
	 * @param user  用户信息
	 * @return  更新或新增成功返回true，否则返回false
	 */
	boolean updateAndSaveUser(User user);
	/**
	 * 根据编号删除用户信息
	 * @param uid  用户编号
	 * @return
	 */
	void deleteById(Integer uid);
	/**
	 * 根据用户编号查询用户信息
	 * @param uid
	 * @return
	 */
	User getUserById(Integer uid);
	
	/**
	 * 查询所有的用户信息
	 * @return 返回用户信息的list集合
	 */
	List<User> getAllUser();
	/**
	 * 分页查询
	 * @param pageable 对象
	 * @return  返回分页的数据对象
	 */
	Page<User> getAllByPage(Pageable pageable);
	/**
	 * 根据名称查询用户信息
	 * @param name  用户名
	 * @return  返回用户对象
	 */
	User getUserByName(String name);
}
