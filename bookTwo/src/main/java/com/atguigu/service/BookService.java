package com.atguigu.service;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {
    void addBook(Book book) throws Exception;
    void deleteBookById(Integer id) throws Exception;
    void updateBook(Book book) throws Exception;
    Book queryBookById(Integer id) throws Exception;
    List<Book> queryBooks() throws Exception;

    Page<Book> page(int pageNo, int pageSize) throws Exception;

    Page<Book> pageByPrice(int pageNo, int pageSize, int max, int min) throws Exception;
}
