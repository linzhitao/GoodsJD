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
            String account = (String) req.getSession().getAttribute("account");
            //如果用户存在，则放行。
            if (account!=null){
                chain.doFilter(req,resp);
            }else {
                if (uri.contains("selectCart")||uri.contains("addCart")){
                    //查看购物车和加入购物车，游客是可以操作的所以放行
                    chain.doFilter(req,resp);
                }else {
                    //其他的请求就会拦截
                    req.setAttribute("login-msg","该页面，需要登陆后才能访问");
                    req.getRequestDispatcher("/WEB-INF/login.jsp").forward(servletRequest,servletResponse);
                }
            }
        }
    }
    @Override
    public void destroy() {

    }
}
