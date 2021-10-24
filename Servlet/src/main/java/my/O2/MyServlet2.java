package my.O2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MyServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应头解决乱码问题
//        response.setHeader("Content-Type" , "text/html;charset=UTF-8");
//        response.setCharacterEncoding("utf-8");
//        response.getWriter().write("信息回传");

        //仅可在获取流对象之前使用
        //response.setContentType("text/html;charset=UTF-8");
        //response.getWriter().write("信息回传");


        response.getWriter().write("target arrived");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println(username);
        Object key = request.getAttribute("key");
        System.out.println(key);
    }
}
