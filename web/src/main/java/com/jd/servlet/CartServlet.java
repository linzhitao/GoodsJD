package com.jd.servlet;

import com.jd.pojo.Products;
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
    private List<Products> guestList = new ArrayList<>();
    private List<Products> products;
    private String cartJspPath = "/WEB-INF/cart.jsp";

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
        //用户id
        Integer uid = (Integer) req.getSession().getAttribute("uid");
        //用户登录
        if(uid!=null){
            //商品id
            Integer pid =Integer.parseInt(req.getParameter("pid"));

            boolean isExist = cartService.deleteGoods(pid,uid);
            if (isExist){
                req.getRequestDispatcher("/selectCart").forward(req, resp);
            }else {
                resp.getWriter().println("删除失败");
            }
        }else {
            //游客
            int pid = Integer.valueOf(req.getParameter("pid"));
            HttpSession session = req.getSession();
            guestList = (List<Products>) session.getAttribute("guestList");
            for (Products product : guestList) {
                Integer pid1 = product.getPid();
                System.out.println(pid1+"--");
                if (pid1==pid){
                    guestList.remove(product);
                    session.setAttribute("guestList",guestList);
                    req.getRequestDispatcher(cartJspPath).forward(req, resp);
                    return;
                }
            }
        }

    }

    //查看购物车
    private void selectCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Integer uid = (Integer) session.getAttribute("uid");
        if(uid!=null){
            products = cartService.queryGoodsByUid(uid);
            session.setAttribute("pro",products);
            req.getRequestDispatcher(cartJspPath).forward(req, resp);
        }else {
            req.getRequestDispatcher(cartJspPath).forward(req, resp);
        }

    }

    //添加购物车
    private void addCart(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Integer uid = (Integer) session.getAttribute("uid");
        Integer pid= Integer.parseInt(req.getParameter("pid"));
        String pname = req.getParameter("pname");
        Double price = Double.valueOf(req.getParameter("price"));

        if(uid!=null){
            //用户登录
            cartService.addCart(uid,pid);
            req.getRequestDispatcher("/commodity").forward(req,resp);
        }else {
            //游客登录
            Products product = new Products();
            product.setPid(pid);
            product.setPname(pname);
            product.setPrice(price);
            guestList.add(product);
            session.setAttribute("guestList",guestList);
            req.getRequestDispatcher("/commodity").forward(req,resp);
        }

    }
}
