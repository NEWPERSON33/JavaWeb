package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

import java.sql.Connection;

public class UserDaoimpl extends BaseDao<User> implements UserDao {

    @Override
    public User queryByname(Connection connection, String username) {
        String sql = "select username , password , email , id from t_user where username=?";
        return super.queryforOne(connection , sql , username);

    }

    @Override
    public User queryBynameandpassword(Connection connection, String username, String password) {
        String sql = "select username , password , email , id from t_user where username=? and password=?";
        return super.queryforOne(connection, sql, username, password);
    }

    @Override
    public int saveInformation(Connection connection, User user) {
        String sql = "insert into t_user(username ,password , email) values(?,?,?)";
        return super.update(connection, sql, user.getUsername(), user.getPassword(), user.getEmail());
    }
}
