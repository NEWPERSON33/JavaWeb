package com.atguigu.dao;

import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OderItemDaoTest {

    @Test
    public void saveOrderItem() throws Exception {
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(0, "胡辣汤", 1, new BigDecimal(100), new BigDecimal(100), "123234"));

    }
}