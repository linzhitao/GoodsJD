package com.jd.service.impl;

import com.jd.bean.User;
import com.jd.dao.LoginDAO;
import com.jd.dao.impl.LoginDAOImpl;
import com.jd.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private LoginDAO loginDao=new LoginDAOImpl();
    //调用LoginDAO接口的register方法
    public Integer loginUser(String account, String password) {
        return loginDao.login(account,password);
    }

    //注册用户时，确认数据库是否有一样的用户。没有才执行insert方法，否则返回false，
    public boolean insertUser(String account, String password) {
        //查询数据库里面是否有此账户
        Integer login = loginDao.login(account, password);
        System.out.println(login);
        //如果返回true代表有值
        if (login!=null){
            System.out.println("用户已存在");
            return false;
        }else {
            return loginDao.insert(account, password);
        }

    }
}
