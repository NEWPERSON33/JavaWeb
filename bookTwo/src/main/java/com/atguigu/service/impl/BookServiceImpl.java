package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) throws Exception {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) throws Exception {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) throws Exception {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) throws Exception {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() throws Exception {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) throws Exception {
        Page<Book> page = new Page<>() ;

        page.setPage_Size(pageSize);
        page.setPageCount(bookDao.queryPageCount());//总记录数
        int pageTotal = page.getPageCount() % pageSize > 0 ? (page.getPageCount() / pageSize) + 1 : page.getPageCount() / pageSize ;
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);//指定页码必须写这里，否则会有bug



        page.setItems(bookDao.queryPage((page.getPageNo() - 1 )*pageSize , pageSize));
        return page ;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int max, int min) throws Exception {
        Page<Book> page = new Page<>() ;
        page.setPage_Size(pageSize);
        page.setPageCount(bookDao.queryPageCount(min , max));
        int pageTotal = page.getPageCount() % pageSize > 0 ? (page.getPageCount() / pageSize) + 1 : page.getPageCount() / pageSize ;
        page.setPageTotal(pageTotal);
        page.setPageNo(pageNo);
        page.setItems(bookDao.queryPageByPrice(min , max ,(page.getPageNo() - 1 )*pageSize , pageSize));
        return page ;
    }
}
