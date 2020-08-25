package com.jd.service;


import com.jd.pojo.Products;

import java.util.List;

public interface CartService {
    //添加购物车
    void addCart(Integer uid, Integer pid);
    //根据uid查询商品
    List<Products> queryGoodsByUid(Integer uid);
    //删除购物车中的某个商品
    boolean deleteGoods(Integer pid, Integer uid);
}
