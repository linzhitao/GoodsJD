package com.jd.servlet;

import com.jd.service.LoginService;
import com.jd.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private LoginService loginService=new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        //将数据传入service层
        Integer uid = loginService.loginUser(account, password);
        if (uid!=null){
            //创建session
            HttpSession session = req.getSession();
            //将uid传入session中
            session.setAttribute("uid",uid);
            //转发commodity请求
            req.getRequestDispatcher("/commodity").forward(req, resp);
        }else {
            resp.getWriter().println("账号或密码错误");
        }

    }
}
