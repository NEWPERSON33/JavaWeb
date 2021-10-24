package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.JDBCUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class OrderServlet extends BaseServlet {
   private OrderService service = new OrderServiceImpl();


    protected void createOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
            return;
        }
        Integer userId = user.getId();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        String orderId = null;

        orderId = service.CreateOrder(cart, userId);
        JDBCUtils.commitAndClose();

        request.getSession().setAttribute("orderId", orderId);
        //request.getRequestDispatcher("").forward(request, response);
        response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
