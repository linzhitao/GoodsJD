package com.jd.dao;


public interface LoginDAO {
    /**
     * 用户登录
     * @param account 账户
     * @param password 密码
     * @return uid
     */
    Integer login(String account, String password);

    /**
     * 用户注册
     * @param account 账户
     * @param password 密码
     * @return
     */
    boolean add(String account, String password);

}
