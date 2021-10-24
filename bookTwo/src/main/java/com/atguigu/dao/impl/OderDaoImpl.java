package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;
import com.atguigu.utils.JDBCUtils;

import java.sql.Connection;

public class OderDaoImpl extends BaseDao<Order> implements OrderDao {
    @Override
    public int saveOrder(Order order) throws Exception {
        Connection connection = null;

            connection = JDBCUtils.getdruidConnection();
            String sql = "insert into t_order(order_id , create_time , total_money , status , user_id) values(?,?,?,?,?)";
            return super.update(connection , sql , order.getOrder_id() , order.getCreat_time() ,
                        order.getTotal_money() , order.getStatus() , order.getUser_id());

    }
}
