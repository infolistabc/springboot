package com.sun.service.impl;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.sun.dao.IAccountDao;
import com.sun.dao.IOrderDao;
import com.sun.entity.Account;
import com.sun.entity.OrderInfo;
import com.sun.service.IAccountService;
import com.sun.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

/**
 * 测试同一类内事务设置
 */
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    IOrderDao iOrderDao;
    @Resource
    IAccountDao iAccountDao;
    @Resource
    IAccountService iAccountService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addOrder() throws Exception{
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setProductor("test");
        orderInfo.setProductName("test");
        orderInfo.setUserId(1L);
        iOrderDao.addOrder(orderInfo);
        updateAccount();
    }

    @Override
    public void updateAccount() throws Exception {
        Account account = new Account();
        account.setOrderId(1L);
        account.setBalance(90);
        iAccountDao.updateAccount(account);
        throw new Exception("异常错误");
    }
}
