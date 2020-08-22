package com.jd.dao.impl;

import com.jd.bean.User;
import com.jd.dao.LoginDAO;
import com.jd.util.Close;

import java.sql.*;

public class LoginDAOImpl implements LoginDAO {
    private Connection conn=null;
    private Statement st =null;
    private ResultSet rs=null;
    private PreparedStatement ps=null;
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
        int uid=0;
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
        return uid;
    }
}
