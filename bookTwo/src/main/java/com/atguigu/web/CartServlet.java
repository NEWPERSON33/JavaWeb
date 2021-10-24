package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void AjaxaddItem(HttpServletRequest request, HttpServletResponse response) throws Exception{
        int id = WebUtils.paseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart==null){
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice()));
        Map<String ,Object> resaMap = new HashMap<>();
        resaMap.put("totalCount", cart.getTotalCount());
        resaMap.put("lastItemname" , book.getName());
        Gson gson = new Gson();
        String json = gson.toJson(resaMap);
        response.getWriter().write(json);
    }

    protected void addItem(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int id = WebUtils.paseInt(request.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart==null){
            cart = new Cart();
            request.getSession().setAttribute("cart", cart);
        }
        cart.addItem(new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice()));
        request.getSession().setAttribute("lastItemname", book.getName());
        response.sendRedirect(request.getHeader("referer"));//请求头中包含着跳转之前地址栏的信息
    }

    protected void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.deleteItem(WebUtils.paseInt(request.getParameter("id"), 0));
        response.sendRedirect(request.getHeader("referer"));
    }


    protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.clear();
        request.getSession().setAttribute("lastItemname", null);
        response.sendRedirect(request.getHeader("referer"));
    }

    protected void updateCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.updateCount(WebUtils.paseInt(request.getParameter("id"), 0) , WebUtils.paseInt(request.getParameter("count") , 0));
        response.sendRedirect(request.getHeader("referer"));
    }


}
