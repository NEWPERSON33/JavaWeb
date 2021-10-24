package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {

        List<Book> books = bookService.queryBooks();
        req.setAttribute("bookList", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int pageNo = WebUtils.paseInt(req.getParameter("pageNo"), 0);
        pageNo++;
        Book book = WebUtils.copyParameterToBean(req.getParameterMap(), new Book());
        bookService.addBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        bookService.deleteBookById(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Book book = bookService.queryBookById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp?method=update").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Book book = WebUtils.copyParameterToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+req.getParameter("pageNo"));
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int pageNo = WebUtils.paseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.paseInt(req.getParameter("pageSize") , Page.PAGE_SIZE);
        Page<Book> page = bookService.page(pageNo , pageSize);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

}
