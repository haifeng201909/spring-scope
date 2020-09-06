package com.haifeng.spring.springscope.controller;

import javax.servlet.*;
import java.io.IOException;

public class HelloController implements Servlet {


    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("调用了 init");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("调用了 service");
        System.out.println("默认编码: " + System.getProperty("file.encoding"));
        String name = servletRequest.getParameter("name");
        /*google浏览器默认编码为 ISO-8859-1*/
        name = new String(name.getBytes("ISO-8859-1"),
                "UTF-8");
        System.out.println(name);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("调用了 destroy");
    }
}
