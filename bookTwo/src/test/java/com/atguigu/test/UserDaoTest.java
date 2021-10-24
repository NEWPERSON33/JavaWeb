package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoimpl;
import com.atguigu.pojo.User;
import com.atguigu.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryByname() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getdruidConnection();
            UserDaoimpl userDaoimpl = new UserDaoimpl();
            System.out.println(userDaoimpl.queryByname(connection, "admin"));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection , null);
        }



    }

    @Test
    public void queryBynameandpassword() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getdruidConnection();
            UserDaoimpl userDaoimpl = new UserDaoimpl();
            System.out.println(userDaoimpl.queryBynameandpassword(connection, "admin" , "root"));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection , null);
        }

    }

    @Test
    public void saveInformation() {
        Connection connection = null;
        try {
            connection = JDBCUtils.getdruidConnection();
            UserDaoimpl userDaoimpl = new UserDaoimpl();
            System.out.println(userDaoimpl.saveInformation(connection,
                    new User("LiuBai" ,"1234556" , "581@gmail.com" )));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeResource(connection , null);
        }

    }
}