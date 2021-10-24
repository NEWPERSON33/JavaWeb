package com.atguigu.web;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceimpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService service = new UserServiceimpl();

    protected void logout(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
        String code = req.getParameter("code");
        String  kaptcha_session_key = (String)req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);
        //User user = new User();
        User user = WebUtils.<User>copyParameterToBean(req.getParameterMap(), new User());
        if (kaptcha_session_key!=null && kaptcha_session_key.equalsIgnoreCase(code)){
            if(!service.existsName(user.getUsername())){
                //service.register(new User(username , password , email));
                service.register(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }else {
                req.setAttribute("msg" , "用户名已存在");
                req.setAttribute("username" , user.getUsername());
                req.setAttribute("email" , user.getEmail());
                //请求转发斜杠开头表示http://localhost:8080/当前工程名/
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
        }else {
            req.setAttribute("msg" , "验证码错误");
            req.setAttribute("username" , user.getUsername());
            req.setAttribute("email" , user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password, null);
        User login = service.login(user);
        if (login != null){
            req.getSession().setAttribute("user" , login);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }else {
            //登录失败


            req.setAttribute("msg" , "用户名或者密码错误");
            req.setAttribute("username" , username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
    }

    protected void ajaxExistUsername(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String username = req.getParameter("username");
        boolean existsName = service.existsName(username);
        Map<String , Object> resMap = new HashMap<>();
        resMap.put("existsName" , existsName);
        Gson gson = new Gson();
        String json = gson.toJson(resMap);
        resp.getWriter().write(json);
    }




}
