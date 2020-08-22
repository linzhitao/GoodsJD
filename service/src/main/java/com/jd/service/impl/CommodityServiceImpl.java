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
    //添加商品
    public boolean insertGoods(String pid, String cid, String pname, double price) {
        return commodityDAO.insertGoods(pid,cid,pname,price);
    }
    //修改商品
    public boolean modifyGood(Products products) {
            return commodityDAO.updateGoods(products);
    }
    //删除商品
    public boolean deleteGoodsByID(String pid) {
        return commodityDAO.deleteGoodsById(pid);
    }
}
