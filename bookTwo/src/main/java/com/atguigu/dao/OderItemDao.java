package com.atguigu.dao;

import com.atguigu.pojo.OrderItem;

public interface OderItemDao {
    int saveOrderItem(OrderItem oderItem) throws Exception;
}
