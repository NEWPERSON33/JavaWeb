package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {

    @Test
    public void createOrder() throws Exception {
        OrderServiceImpl orderService = new OrderServiceImpl();
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "fufu", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(3, "xixix" , 1 , new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "mimi" , 1 , new BigDecimal(100), new BigDecimal(100)));
        orderService.CreateOrder(cart, 1);
    }
}