package com.atguigu.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class WebUtilsTest {

    @Test
    public void paseInt() {
        System.out.println(WebUtils.paseInt("15w", 16));
    }
}