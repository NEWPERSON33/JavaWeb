package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService service = new UserServiceimpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        try {
            if (service.login(new User(username , password , null))!=null){
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
            }else {
                //登录失败


                req.setAttribute("msg" , "用户名或者密码错误");
                req.setAttribute("username" , username);
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
