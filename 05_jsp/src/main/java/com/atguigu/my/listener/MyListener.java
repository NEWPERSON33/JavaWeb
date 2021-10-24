package com.atguigu.my.listener;

import javax.servlet.*;
import javax.servlet.http.*;

public class MyListener implements ServletContextListener {

    public MyListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
        System.out.println("servletContext对象销毁");
    }


}
