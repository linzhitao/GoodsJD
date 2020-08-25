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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private LoginService loginService=new LoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //因为默认是get请求，所以我用来跳转页面
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //页面提交表单1
        //获取请求的值
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        boolean insertyN = loginService.insertUser(account, password);
        HttpSession session = req.getSession();
        if (insertyN){
            session.setAttribute("color","注册成功，请登录！");
            //注册成功，转发到登录页面
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }else {
            session.setAttribute("color","注册失败,需要重新注册！");
            resp.setHeader("refresh", "3;url=/register");
        }

    }
}
