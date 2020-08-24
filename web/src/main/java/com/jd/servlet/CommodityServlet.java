package com.jd.servlet;

import com.jd.bean.Products;
import com.jd.service.CommodityService;
import com.jd.service.impl.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CommodityServlet extends HttpServlet {
    private CommodityService commodityService=new CommodityServiceImpl();
    private String prices="price";
    private String pnames="pname";
    private String comm="/commodity";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req,resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        if (comm.equals(servletPath)){
            commodity(req,resp);
        }else if ("/GotoAdd".equals(servletPath)){
            gotoAdd(req,resp);
        }else if ("/addGoods".equals(servletPath)){
            addGoods(req, resp);
        }else if ("/modif".equals(servletPath)){
            modif(req,resp);
        }else if ("/modifyGoods".equals(servletPath)){
            modifyGoods(req,resp);
        }else if ("/GoodsDrop".equals(servletPath)){
            goodsDrop(req,resp);
        }
    }
    //删除商品
    private void goodsDrop(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String pid = req.getParameter("pid");
        boolean b = commodityService.deleteGoodsByID(pid);
        if (b){
            req.getRequestDispatcher(comm).forward(req,resp);
        }

    }

    //获取修改页面请求参数
    private void modifyGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int pid = Integer.parseInt(req.getParameter("pid"));
        int cid = Integer.parseInt(req.getParameter("cid"));
        String pname = req.getParameter(pnames);
        Double price =Double.valueOf(req.getParameter(prices)) ;
        System.out.println(pname);
        Products products = new Products(pid, cid, pname, price);

        boolean isExist = commodityService.modifyGood(products);
        if (isExist){
            req.getRequestDispatcher(comm).forward(req,resp);
        }else {
            resp.getWriter().println("id已存在");
            //重定向回到商品表
            req.getRequestDispatcher(comm).forward(req,resp);
        }
    }

    //点击修改商品时，拿到要修改商品的所有数据，返回页面显示
    private void modif(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pid = Integer.parseInt(req.getParameter("pid"));
        Integer cid = Integer.parseInt(req.getParameter("cid"));
        String pname = req.getParameter(pnames);
        double price = Double.parseDouble(req.getParameter(prices));
        HttpSession session = req.getSession();
        session.setAttribute("pid",pid);
        session.setAttribute("cid",cid);
        session.setAttribute("pname",pname);
        session.setAttribute("price",price);
        req.getRequestDispatcher("/WEB-INF/modifGoods.jsp").forward(req, resp);
    }

    //跳转添加网页
    private void gotoAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/addGoods.jsp").forward(req, resp);
    }

    //添加商品
    private void addGoods(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //获取表单元素
        String pid = req.getParameter("pid");
        String cid = req.getParameter("cid");
        String pname = req.getParameter(pnames);
        double price = Double.valueOf(req.getParameter(prices));
        //传入service层
        boolean isExist = commodityService.insertGoods(pid,cid,pname, price);
        if (isExist){
            req.getRequestDispatcher(comm).forward(req,resp);
        }else {
            resp.getWriter().println("添加失败");
            //3秒刷新网页
            req.getRequestDispatcher(comm).forward(req,resp);
        }
    }

    //查询商品
    private void commodity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用service层，查询商品表
        List<Products> products = commodityService.selectAll();
        HttpSession session = req.getSession();
        session.setAttribute("products",products);
        req.getRequestDispatcher("/WEB-INF/shopping.jsp").forward(req,resp);
    }
}
