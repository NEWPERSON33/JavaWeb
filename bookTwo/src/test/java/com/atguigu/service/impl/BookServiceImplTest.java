package com.atguigu.service.impl;

import com.atguigu.service.BookService;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookServiceImplTest {
    private BookService bookService = new BookServiceImpl();

    @Test
    public void page() throws Exception {
        System.out.println(bookService.page(1, 4));
    }
}