package com.jd.service;


public interface LoginService {
    //登录
    Integer loginUser(String account, String password);

    //用户注册
    boolean insertUser(String account, String password);
}
