package com.atguigu.dao;

import com.atguigu.dao.impl.OderDaoImpl;
import com.atguigu.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void saveOrder() throws Exception {
        OderDaoImpl oderDao = new OderDaoImpl();
        oderDao.saveOrder(new Order("123234", new Date(), new BigDecimal(100), 0, 1));
    }
}