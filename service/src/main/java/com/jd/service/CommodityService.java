package com.jd.service;

import com.jd.pojo.Products;

import java.util.List;

public interface CommodityService {
    //查询所有商品
    List<Products> selectAll();
    //添加商品
    boolean insertGoods(String pid, String cid, String pname, double price);
    //修改商品
    boolean modifyGood(Products products);
    //删除商品
    boolean deleteGoodsByID(String pid);
}
