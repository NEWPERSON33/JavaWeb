package my;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("get");
        ServletConfig servletConfig = getServletConfig();
        ServletContext servletContext = servletConfig.getServletContext();
        System.out.println(servletContext.getInitParameter("ID"));
        System.out.println(servletContext.getInitParameter("check"));
        System.out.println(servletContext.getContextPath());
        System.out.println(servletContext.getRealPath("/image/1.png"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post");
    }
}
