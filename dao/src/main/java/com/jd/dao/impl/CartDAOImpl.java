package com.jd.dao.impl;

import com.jd.dao.CartDAO;
import com.jd.util.Close;

import java.sql.*;

public class CartDAOImpl implements CartDAO {
    private Connection conn = Close.getConn();
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private boolean sure=true;
    private String sql;

    //添加
    public void insert(Integer uid, Integer pid) {
        try {
            conn = Close.getConn();
            sql = "insert into itable (uid,pid) values (?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,uid);
            ps.setInt(2,pid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(ps,conn);
        }
    }

    public boolean selectByPid(Integer pid) {
        try {
            conn = Close.getConn();
            sql = "select * from itable where pid =?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1,pid);
            rs = ps.executeQuery();
            sure = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(ps,conn);
        }
        return sure;
    }
}
