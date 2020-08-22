package com.jd.service;

import com.jd.bean.User;

public interface LoginService {
    //登录
    Integer loginUser(String account, String password);
}
