package com.atguigu.pojo;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    private Cart cart = new Cart() ;

    @Test
    public void addItem() {
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "java编程思想", 1, new BigDecimal(1000), new BigDecimal(1000)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
    }

    @Test
    public void clear() {



    }

    @Test
    public void updateCount() {
        cart.addItem(new CartItem(1, "java", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.updateCount(1, 10);
        System.out.println(cart);
    }
}