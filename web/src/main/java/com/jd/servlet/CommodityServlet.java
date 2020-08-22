package com.jd.servlet;

import com.jd.bean.Products;
import com.jd.service.CommodityService;
import com.jd.service.impl.CommodityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CommodityServlet extends HttpServlet {
    private CommodityService commodityService=new CommodityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doRequest(req,resp);
    }

    private void doRequest(HttpServletRequest req, HttpServletResponse resp) {
        String servletPath = req.getServletPath();
        if ("/commodity".equals(servletPath)){
            commodity(req,resp);
        }
    }

    private void commodity(HttpServletRequest req, HttpServletResponse resp) {
        //调用service层，查询商品表
        List<Products> products = commodityService.selectAll();
    }
}
