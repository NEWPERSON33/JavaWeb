package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OderItemDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OderDaoImpl();
    private OderItemDao oderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String CreateOrder(Cart cart, Integer userId) throws Exception {
        String orderId= System.currentTimeMillis()+""+userId ;
        orderDao.saveOrder(new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId));
        for (Map.Entry<Integer , CartItem> entry:cart.getItems().entrySet()) {
            CartItem item = entry.getValue();
            oderItemDao.saveOrderItem(new OrderItem(null, item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), orderId));
            Book book = bookDao.queryBookById(item.getId());
            book.setSales(book.getSales()+item.getCount());
            book.setStock(book.getStock() - item.getCount());
            bookDao.updateBook(book);
        }
        cart.clear();
        return orderId;

    }
}
