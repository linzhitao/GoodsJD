package com.jd.servlet;

import com.jd.bean.Products;
import com.jd.service.CartService;
import com.jd.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CartServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req,resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String servletPath = req.getServletPath();
        if ("/addCart".equals(servletPath)){
            addCart(req,resp);
        }else if ("/selectCart".equals(servletPath)){
            selectCart(req,resp);
        }
    }

    //查看购物车
    private void selectCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer uid = (Integer) session.getAttribute("uid");
        List<Products> products = cartService.queryGoodsByUid(uid);
        session.setAttribute("pro",products);
        req.getRequestDispatcher("/WEB-INF/cart.jsp").forward(req, resp);
    }

    //添加购物车
    private void addCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Integer uid = (Integer) session.getAttribute("uid");
        Integer pid= Integer.parseInt(req.getParameter("pid"));
        cartService.addCart(uid,pid);
        resp.sendRedirect("/commodity");
    }
}
