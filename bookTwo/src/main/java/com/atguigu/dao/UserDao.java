package com.atguigu.dao;

import com.atguigu.pojo.User;

import java.sql.Connection;

public interface UserDao {

    User queryByname(Connection connection, String username);
    User queryBynameandpassword( Connection connection , String username , String password);
    int saveInformation( Connection connection , User user);
}
