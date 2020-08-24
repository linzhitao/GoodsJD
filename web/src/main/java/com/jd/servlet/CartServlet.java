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
import java.util.ArrayList;
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
        }else if ("/reGoodsCart".equals(servletPath)){
            reGoodsCart(req,resp);
        }
    }
    //购物车中删除某个商品
    private void reGoodsCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pid =Integer.parseInt(req.getParameter("pid"));
        Integer uid = (Integer) req.getSession().getAttribute("uid");
        boolean d = cartService.deleteGoods(pid,uid);
        if (d){
            req.getRequestDispatcher("/selectCart").forward(req, resp);
        }else {
            System.out.println();
        }
    }

    //查看购物车
    private void selectCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer uid = (Integer) session.getAttribute("uid");
        if(uid!=null){
            List<Products> products = cartService.queryGoodsByUid(uid);
            session.setAttribute("pro",products);
            req.getRequestDispatcher("/WEB-INF/cart.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/WEB-INF/cart.jsp").forward(req, resp);
        }

    }

    //添加购物车
    private void addCart(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Integer uid = (Integer) session.getAttribute("uid");
        Integer pid= Integer.parseInt(req.getParameter("pid"));
        String pname = req.getParameter("pname");
        Double price = Double.valueOf(req.getParameter("price"));
        List<Products> guestList = new ArrayList<>();

        if(uid!=null){
            //用户登录
            cartService.addCart(uid,pid);
            req.getRequestDispatcher("/commodity").forward(req,resp);

        }else {
            System.out.println(1);
            //游客登录
            Products products = new Products();
            products.setPid(pid);
            products.setPname(pname);
            products.setPrice(price);
            guestList.add(products);
            System.out.println(products.toString());
            req.getSession().setAttribute("guestList",guestList);
            req.getRequestDispatcher("/commodity").forward(req,resp);
        }

    }
}
