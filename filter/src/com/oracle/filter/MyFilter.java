package com.oracle.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化filter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1，获取session
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        HttpSession session=req.getSession();
        //2，看session里有无登录信息
        String username=String.valueOf(session.getAttribute("username"));

        //3.有，放行，没有弹回登录页面    如果是login请求就放行
        if(username.equals("null")&&!req.getRequestURI().contains("login")&&!req.getRequestURI().contains("images")&&!req.getRequestURI().contains("css")&&!req.getRequestURI().endsWith(".js")){
            //filterChain.doFilter(servletRequest,servletResponse);
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else{
            //req.getRequestDispatcher("login.jsp").forward(req,resp);
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("销毁filter");
    }
}
