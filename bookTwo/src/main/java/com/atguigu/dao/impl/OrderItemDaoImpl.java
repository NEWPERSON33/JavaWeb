package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OderItemDao;
import com.atguigu.pojo.OrderItem;
import com.atguigu.utils.JDBCUtils;

import java.sql.Connection;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OderItemDao {
    @Override
    public int saveOrderItem(OrderItem oderItem) throws Exception {
        Connection connection = null;

            connection = JDBCUtils.getdruidConnection();
            String sql = "insert into t_order_item( name , price , total_money , count , order_id) values(?,?,?,?,?)";
            return super.update(connection, sql,  oderItem.getName() ,
                    oderItem.getPrice() , oderItem.getTotal_money() , oderItem.getCount() , oderItem.getOrder_id());

    }
}
