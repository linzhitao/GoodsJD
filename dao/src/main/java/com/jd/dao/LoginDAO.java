package com.jd.dao;

import com.jd.bean.User;

public interface LoginDAO {
    //用户登录
    Integer login(String account, String password);
}