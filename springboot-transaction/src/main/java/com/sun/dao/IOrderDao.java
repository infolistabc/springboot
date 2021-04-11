package com.sun.dao;

import com.sun.entity.OrderInfo;

public interface IOrderDao {
    boolean addOrder(OrderInfo orderInfo);
}
