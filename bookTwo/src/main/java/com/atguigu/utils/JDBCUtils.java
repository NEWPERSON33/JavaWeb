package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 使用系统类加载器在部署tomcat时会导致空指针异常
 */
public class JDBCUtils {
    public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
        //InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties() ;
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection ;
    }

    private static DataSource DruidDataSource = null;
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();
    public static Connection getdruidConnection() throws Exception {
        if(DruidDataSource == null){
            //InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            DruidDataSource = DruidDataSourceFactory.createDataSource(properties);
        }
        Connection connection = conns.get();
        if(connection == null){
            connection = DruidDataSource.getConnection();
            conns.set(connection);
            connection.setAutoCommit(false);
        }
        return connection ;
    }

    private static DataSource dataSource = null;
    public static  Connection getdbcpConnection() throws Exception {
        if(dataSource == null){
            //InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("dbcp.properties");
            Properties properties = new Properties() ;
            properties.load(resourceAsStream);
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        }
        return dataSource.getConnection();
    }

    public static void closeResource(Connection connection , Statement statement){
        try {
            if(statement != null)
                statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection != null){

            try {
                connection.commit();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();//服务器的线程池技术，值需要被回收，不然会出现重复利用连接的情况
    }

    public static void rollbackAndclose(){
        Connection connection = conns.get();
        if (connection != null){

            try {
                connection.rollback();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        conns.remove();//服务器的线程池技术，值需要被回收，不然会出现重复利用连接的情况
    }

    public static void closeResource(Connection connection , Statement statement , ResultSet res){

        try {
            if(res != null)
                res.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            if(statement != null)
                statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

}
