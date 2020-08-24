package com.jd.dao.impl;

import com.jd.dao.Bean;
import com.jd.dao.LoginDAO;
import com.jd.util.Close;

import java.sql.*;

public class LoginDAOImpl extends Bean implements LoginDAO {
    //用户登录sql注入
    public void selectUserSQlinject(String account, String password){
        try {
            sql="select * from user where account=''"+account+"'and password='"+password+"'";
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                sure=true;
            }else {
                sure=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(resultSet,statement,conn);
        }

    }


    //用户登录非sql注入
    public Integer login(String account, String password) {
        Integer uid=null;
        try {
            sql = "select * from user where account=? and password=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                uid = resultSet.getInt("uid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(resultSet,preparedStatement,conn);
        }
        System.out.println(uid);
        return uid;
    }

    //注册l
    public boolean insert(String account, String password) {
        try {
            sql="INSERT INTO user (account,password) VALUE (?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);
            int rse = preparedStatement.executeUpdate();
            if (rse>0){
                sure=true;
            }else {
                sure=false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(preparedStatement, conn);
        }
        return sure;
    }
}
