package com.jd.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharsetEncodingFilter implements Filter{
    private static String encoding;///定义变量接收初始化的值


    public void init(FilterConfig filterConfig) throws ServletException {
        // 接收web.xml配置文件中的初始参数
        encoding = filterConfig.getInitParameter("CharsetEncoding");

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy() {

    }
}
