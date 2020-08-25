package com.jd.service.impl;

import com.jd.pojo.Products;
import com.jd.dao.CartDAO;
import com.jd.dao.CommodityDAO;
import com.jd.dao.impl.CartDAOImpl;
import com.jd.dao.impl.CommodityDAOImpl;
import com.jd.service.CartService;

import java.util.List;

public class CartServiceImpl  implements CartService {
    private CartDAO cartDAO= new CartDAOImpl();
    private CommodityDAO commodityDAO=new CommodityDAOImpl();

    public void addCart(Integer uid, Integer pid) {
        //判断pid商品是否存在，不存在则添加
        boolean isExist = cartDAO.selectByPid(pid);
        if (isExist){
            System.out.println("商品已存在购物车");
        }else {
            cartDAO.add(uid,pid);
        }
    }

    public List<Products> queryGoodsByUid(Integer uid) {
        return commodityDAO.queryGoodsByUid(uid);
    }

    public boolean deleteGoods(Integer pid, Integer uid) {
        return cartDAO.delete(pid,uid);
    }

}
