package com.jd.dao;

public interface CartDAO {
    /**
     * 将用户id和商品id添加入中间表
     * @param uid 用户id
     * @param pid 商品id
     */
    void insert(Integer uid, Integer pid);

    /**
     * 判断pid是否
     * @param pid
     * @return
     */
    boolean selectByPid(Integer pid);

    /**
     * 删除购物车中的商品
     * @param pid
     * @param uid
     * @return
     */
    boolean deleteGoods(Integer pid, Integer uid);

}
