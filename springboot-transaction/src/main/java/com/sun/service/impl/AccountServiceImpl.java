package com.sun.service.impl;


import com.sun.dao.IAccountDao;
import com.sun.entity.Account;
import org.springframework.stereotype.Service;
import com.sun.service.IAccountService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements IAccountService {
	@Resource
	IAccountDao iAccountDao;
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)
	@Override
	public void updateAccount() throws Exception{
		Account account = new Account();
		account.setOrderId(1L);
		account.setBalance(90);
		iAccountDao.updateAccount(account);
		throw new Exception("异常错误");
	}
}
