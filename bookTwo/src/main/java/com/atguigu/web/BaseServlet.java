package com.atguigu.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.*;

public class BaseServlet extends HttpServlet {

    private Class type = this.getClass();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String action = req.getParameter("action");
        Method declaredMethod = null;
        try {
            declaredMethod = type.getDeclaredMethod(action , HttpServletRequest.class , HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            declaredMethod.invoke(this , req , resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        String action = req.getParameter("action");
        Method declaredMethod = null;
        try {
            declaredMethod = type.getDeclaredMethod(action , HttpServletRequest.class , HttpServletResponse.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try {
            declaredMethod.invoke(this , req , resp);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
