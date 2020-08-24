package com.jd.dao;

public interface CartDAO {
    //添加uid，pid
    void insert(Integer uid, Integer pid);

    //根据pid查询
    boolean selectByPid(Integer pid);

    //删除购物车中的商品
    boolean deleteGoods(Integer pid, Integer uid);

}
