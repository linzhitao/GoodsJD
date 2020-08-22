package com.jd.service.impl;

import com.jd.bean.Products;
import com.jd.dao.CommodityDAO;
import com.jd.dao.impl.CommodityDAOImpl;
import com.jd.service.CommodityService;

import java.util.List;

public class CommodityServiceImpl implements CommodityService {
    private CommodityDAO commodityDAO=new CommodityDAOImpl();
    //调用dao层与数据库交互，查看商品并返回
    public List<Products> selectAll() {
        return commodityDAO.findProducts();
    }
}
