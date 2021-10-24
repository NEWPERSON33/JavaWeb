package com.atguigu.my.Myservlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // System.out.println("receive the post");
        request.setCharacterEncoding("UTF-8");

        if(ServletFileUpload.isMultipartContent(request)){
            FileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                for (FileItem fileItem: fileItems) {
                    if(fileItem.isFormField()){
                        System.out.println("获取表单项name:"+fileItem.getFieldName());
                        System.out.println("表单项value" + fileItem.getString("UTF-8"));
                    }else {
                        System.out.println("获取表单项name:"+fileItem.getFieldName());
                        System.out.println("上传文件名:"+fileItem.getName());
                        fileItem.write(new File("H:\\JavaWorkTwo\\JavaWeb\\05_jsp\\"+fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
