package com.jd.service;

import com.jd.bean.Products;

import java.util.List;

public interface CommodityService {
    List<Products> selectAll();

    boolean insertGoods(String pid, String cid, String pname, double price);

    boolean modifyGood(Products products);
}
