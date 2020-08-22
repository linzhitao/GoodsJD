package com.jd.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        //1.获取HttpServletRequest对象
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse resp=(HttpServletResponse)servletResponse;
        //获取访问的路径
        String uri = req.getServletPath();
        //判断，如果访问路径是往登录界面或其他不需要登录的界面就放行

        if (uri.contains("login") || uri.contains("register") || uri.contains("commodity")){
            chain.doFilter(req,resp);
        }else {
            req.setAttribute("login-msg","该页面，需要登陆后才能访问");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(servletRequest,servletResponse);
            /*String account = (String) req.getSession().getAttribute("account");
            //如果用户存在，则放行。
            if (account!=null){
                chain.doFilter(req,resp);
            }else {
                if (uri.contains("GotoAdd")||uri.contains("modif")||uri.contains("GoodsDrop")){
                    //处于游客登录拦截添加商品，修改商品，删除商品，
                    req.setAttribute("login-msg","该页面，需要登陆后才能访问");
                    req.getRequestDispatcher("/WEB-INF/login.jsp").forward(servletRequest,servletResponse);
                }else {
                    //其余页面和请求,游客登录也可以访问，所以放行
                    chain.doFilter(req,resp);
                }
            }*/
        }

    }

    @Override
    public void destroy() {

    }
}
