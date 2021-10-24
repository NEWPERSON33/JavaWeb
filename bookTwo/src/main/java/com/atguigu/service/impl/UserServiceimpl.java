package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoimpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.utils.JDBCUtils;

import java.sql.Connection;

public class UserServiceimpl implements UserService {

    private static UserDao userDao = new UserDaoimpl();

    @Override
    public boolean register(User user) throws Exception {
        Connection connection = null;

            connection = JDBCUtils.getdruidConnection();
            if(!existsName(connection , user.getUsername())){
                userDao.saveInformation(connection , user);
                return true;
            }


        return false;
    }

    @Override
    public User login(User user) throws Exception {
        Connection connection = null;
        User user1 = null ;

            connection = JDBCUtils.getdruidConnection();
            user1 = userDao.queryBynameandpassword(connection, user.getUsername(), user.getPassword());



        return user1 ;
    }

    @Override
    public boolean existsName(String username) throws Exception {

        Connection connection = null;
        User user = null ;

            connection = JDBCUtils.getdruidConnection();
            user = userDao.queryByname(connection, username);


        if (user==null)
            return false;
        return true ;
    }

    public boolean existsName( Connection connection , String username){
        User user = userDao.queryByname(connection, username);


        if (user==null)
            return false;
        return true ;
    }


}
