package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int pageNo = WebUtils.paseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.paseInt(req.getParameter("pageSize") , Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo , pageSize);
        page.setUrl("client/bookservlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int pageNo = WebUtils.paseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.paseInt(req.getParameter("pageSize") , Page.PAGE_SIZE);
        int min = WebUtils.paseInt(req.getParameter("min"), 0);
        int max = WebUtils.paseInt(req.getParameter("max"), Integer.MAX_VALUE);

        Page<Book> page = bookService.pageByPrice(pageNo , pageSize , max , min);
        page.setUrl("client/bookservlet?action=pageByPrice&min="+min+"&max="+max);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

}
