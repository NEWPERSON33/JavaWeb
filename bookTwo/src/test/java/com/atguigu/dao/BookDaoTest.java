package com.atguigu.dao;

import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.google.protobuf.ByteString;
import org.junit.After;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addBook() {
        //bookDao.addBook(new Book(null, "Computer system", "Jos",
                       // new BigDecimal(50), 1000, 0, null));

    }

    @Test
    public void deleteBookById() {
            //bookDao.deleteBookById(20);
    }

    @Test
    public void updateBook() {
        //bookDao.updateBook(new Book(20, "Computer networks", "Jos",
                //new BigDecimal(50), 1000, 0, null));
    }

    @Test
    public void queryBookById() {
        //System.out.println(bookDao.queryBookById(20));
    }

    @Test
    public void queryBooks() {
        //System.out.println(bookDao.queryBooks());
    }

    @Test
    public void queryPageCount(){
        //System.out.println(bookDao.queryPageCount());
    }

    @Test
    public void queryPage(){
        //System.out.println(bookDao.queryPage(0, 4));
    }

}