package com.jd.dao;

import com.jd.bean.Products;

import java.util.List;

public interface CommodityDAO {
    List<Products> findProducts();
}
