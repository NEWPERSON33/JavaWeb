package com.atguigu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao<T> {

    private Class<T> type = null ;
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        type = (Class<T>) actualTypeArguments[0];
    }


    private QueryRunner queryRunner = new QueryRunner() ;

    public int update(Connection connection , String sql ,  Object ...args){
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return -1;
    }

    public T queryforOne(Connection connection , String sql , Object ...args){
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null ;
    }

    public List<T> querryForList(Connection connection , String sql , Object ...args) {
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public <E>E getOneValue(Connection connection , String sql ,  Object ...args){
        try {
            return queryRunner.query(connection, sql, new ScalarHandler<E>(), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null ;
    }

}
