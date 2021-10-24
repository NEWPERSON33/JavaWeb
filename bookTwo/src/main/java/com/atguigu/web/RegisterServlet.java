package com.atguigu.web;

import com.atguigu.dao.impl.UserDaoimpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UserService service = new UserServiceimpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if ("bnbnp".equals(code)){
            try {
                if(!service.existsName(username)){
                    service.register(new User(username , password , email));
                    req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
                }else {
                    req.setAttribute("msg" , "用户名已存在");
                    req.setAttribute("username" , username);
                    req.setAttribute("email" , email);
                    //请求转发斜杠开头表示http://localhost:8080/当前工程名/
                    req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            req.setAttribute("msg" , "验证码错误");
            req.setAttribute("username" , username);
            req.setAttribute("email" , email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
    }
}
