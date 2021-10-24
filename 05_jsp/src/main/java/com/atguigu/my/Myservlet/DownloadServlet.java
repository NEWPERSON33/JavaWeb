package com.atguigu.my.Myservlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String FileName = "tooth.png" ;

        ServletContext servletContext = getServletContext();

        String mimeType = servletContext.getMimeType("/file/" + FileName);
        //返回数据类型
        response.setContentType(mimeType);
        response.setHeader("content-disposition" , "attachment;filename="+FileName);


        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + FileName);

        ServletOutputStream outputStream = response.getOutputStream();

        IOUtils.copy(resourceAsStream, outputStream);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
