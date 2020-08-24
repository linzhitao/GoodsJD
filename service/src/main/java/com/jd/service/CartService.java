package com.jd.service;


import com.jd.bean.Products;

import java.util.List;

public interface CartService {
    //添加购物车
    void addCart(Integer uid, Integer pid);
    //根据uid查询商品
    List<Products> queryGoodsByUid(Integer uid);

    boolean deleteGoods(Integer pid, Integer uid);
}
