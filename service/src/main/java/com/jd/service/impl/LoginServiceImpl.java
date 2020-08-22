package com.jd.service.impl;

import com.jd.bean.User;
import com.jd.dao.LoginDAO;
import com.jd.dao.impl.LoginDAOImpl;
import com.jd.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private LoginDAO loginDao=new LoginDAOImpl();

    public Integer loginUser(String account, String password) {
        return loginDao.login(account,password);
    }
}
