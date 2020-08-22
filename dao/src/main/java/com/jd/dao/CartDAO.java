package com.jd.dao;

import com.jd.bean.Products;

import java.util.List;

public interface CartDAO {
    //添加uid，pid
    void insert(Integer uid, Integer pid);

    boolean selectByPid(Integer pid);
}
