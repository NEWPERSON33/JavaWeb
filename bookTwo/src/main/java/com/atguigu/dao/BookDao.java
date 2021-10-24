package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    int addBook(Book book) throws Exception;
    int deleteBookById(Integer id) throws Exception;
    int updateBook(Book book) throws Exception;
    Book queryBookById(Integer id) throws Exception;
    List<Book> queryBooks() throws Exception;

    Integer queryPageCount() throws Exception;

    List<Book> queryPage(int begin , int pageSize) throws Exception;

    Integer queryPageCount(int min, int max) throws Exception;

    List<Book> queryPageByPrice(int min, int max , int begin , int pageSize) throws Exception;
}
