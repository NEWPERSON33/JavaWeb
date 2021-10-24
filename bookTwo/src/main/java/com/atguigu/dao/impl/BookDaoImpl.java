package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;
import com.atguigu.pojo.Book;
import com.atguigu.utils.JDBCUtils;

import java.sql.Connection;
import java.util.List;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {
    @Override
    public int addBook(Book book) throws Exception {
        Connection connection = null;
        connection = JDBCUtils.getdruidConnection();
        String sql = "insert into t_book(name , price , author , sales , stock , img_path) values(?,?,?,?,?,?)";
        return super.update(connection ,sql,
                    book.getName() , book.getPrice() ,
                    book.getAuthor() , book.getSales() ,
                    book.getStock() , book.getImgPath());



    }

    @Override
    public int deleteBookById(Integer id) throws Exception {
        Connection connection = null ;

        connection = JDBCUtils.getdruidConnection();
        String sql = "delete from t_book where id = ?";
        return super.update(connection , sql , id);


    }

    @Override
    public int updateBook(Book book) throws Exception {
        Connection connection = null ;

        connection = JDBCUtils.getdruidConnection();
        String sql = "update t_book set name=? , price= ? , author = ? , sales = ? , stock = ? , img_path = ? where id = ?";
        return super.update(connection , sql , book.getName() , book.getPrice() , book.getAuthor() , book.getSales() , book.getStock() , book.getImgPath() , book.getId());

    }

    @Override
    public Book queryBookById(Integer id) throws Exception {
        Connection connection = null ;

        connection = JDBCUtils.getdruidConnection();
        String sql = "select id , name , price , author , sales , stock , img_path imgPath from t_book where id=?";
        return super.queryforOne(connection , sql ,id );

    }

    @Override
    public List<Book> queryBooks() throws Exception {
        Connection connection = null ;

        connection = JDBCUtils.getdruidConnection();
        String sql = "select id , name , price , author , sales , stock , img_path imgPath from t_book ";
        return super.querryForList(connection , sql);


    }

    @Override
    public Integer queryPageCount() throws Exception {
        Connection connection = null;

        connection = JDBCUtils.getdruidConnection();
        String sql = "select count(*) from t_book";

        Long value =  super.<Long>getOneValue(connection, sql);
        Number Revalue = (Number) value ;
        return Revalue.intValue();


    }

    @Override
    public List<Book> queryPage(int begin , int pageSize) throws Exception {
        Connection connection = null;

        connection = JDBCUtils.getdruidConnection();
        String sql = "select id , name , price , author , sales , stock , img_path imgPath from t_book limit ? , ?";
        return super.querryForList(connection, sql, begin , pageSize);

    }

    @Override
    public Integer queryPageCount(int min, int max) throws Exception {
        Connection connection = null;

        connection = JDBCUtils.getdruidConnection();
        String sql = "select count(*) from t_book where price between ? and ?";

        Long value =  super.<Long>getOneValue(connection, sql , min , max);
        Number Revalue = (Number) value ;
        return Revalue.intValue();


    }

    @Override
    public List<Book> queryPageByPrice(int min, int max, int begin, int pageSize) throws Exception {
        Connection connection = null;

        connection = JDBCUtils.getdruidConnection();
        String sql = "select id , name , price , author , sales , stock , img_path imgPath from t_book where" +
                    " price between ? and ? order by price limit ? , ? ";
        return super.querryForList(connection, sql,min ,max, begin , pageSize );

    }
}
