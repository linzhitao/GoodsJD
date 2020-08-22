package com.jd.dao;

import com.jd.bean.Products;

import java.util.List;

public interface CommodityDAO {
    //查询全部商品
    List<Products> findProducts();
    //添加商品
    boolean insertGoods(String pid, String cid, String pname, double price);
    //修改商品
    boolean updateGoods(Products products);
    //删除商品
    boolean deleteGoodsById(String pid);
    //通过pid获取商品
    List<Products> queryGoodsByUid(Integer uid);
}
