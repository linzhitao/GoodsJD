package com.jd.dao.impl;

import com.jd.dao.LoginDAO;
import com.jd.util.Close;

import java.sql.*;

public class LoginDAOImpl implements LoginDAO {
    private Connection conn;
    private Statement st ;
    private ResultSet rs;
    private PreparedStatement ps;
    private boolean sure=false;
    private String sql;

    //用户登录sql注入
    public void selectUserSQlinject(String account, String password){
        try {
            conn=Close.getConn();
            sql="select * from user where account=''"+account+"'and password='"+password+"'";
            rs = st.executeQuery(sql);
            if (rs.next()){
                sure=true;
            }else {
                sure=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(rs,st,conn);
        }

    }


    //用户登录非sql注入
    public Integer login(String account, String password) {
        Integer uid=null;
        try {
            conn = Close.getConn();
            sql = "select * from user where account=? and password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
                uid = rs.getInt("uid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(rs,ps,conn);
        }
        System.out.println(uid);
        return uid;
    }

    //注册l
    public boolean insert(String account, String password) {
        try {
            sql="INSERT INTO user (account,password) VALUE (?,?)";
            Connection conn = Close.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1,account);
            ps.setString(2,password);
            int rs = ps.executeUpdate();
            if (rs>0){
                sure=true;
            }else {
                sure=false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(ps, conn);
        }
        return sure;
    }
}
