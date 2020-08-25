package com.jd.dao;

import com.jd.pojo.Products;

import java.util.List;

public interface CommodityDAO {
    /**
     * 查询所有商品
     * @return 商品集合
     */
    List<Products> findProducts();

    /**
     *添加商品
     * @param pid 商品id
     * @param cid 类别id
     * @param pname 商品名称
     * @param price 商品价格
     * @return
     */
    boolean add(String pid, String cid, String pname, double price);

    /**
     * 修改商品
     * @param products 商品信息
     * @return
     */
    boolean update(Products products);

    /**
     * 删除某个商品
     * @param pid 商品id
     * @return
     */
    boolean delete(String pid);

    /**
     * 通过uid获取商品
     * @param uid 用户id
     * @return
     */
    List<Products> queryGoodsByUid(Integer uid);
}
