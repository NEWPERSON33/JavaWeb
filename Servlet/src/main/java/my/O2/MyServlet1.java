package my.O2;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MyServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求重定向
        System.out.println("原地址被访问");
        response.setStatus(302);
        response.setHeader("Location" , "http://localhost:8080/Servlet/hello1.2");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf8");
        String username = request.getParameter("username");
        //String password = request.getParameter("password");
        System.out.println(username);
        request.setAttribute("key" , "IDcard");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/hello1.2");
        requestDispatcher.forward(request , response);
    }
}
