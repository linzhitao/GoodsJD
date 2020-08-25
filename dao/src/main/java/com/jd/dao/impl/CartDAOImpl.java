package com.jd.dao.impl;

import com.jd.dao.Bean;
import com.jd.dao.CartDAO;
import com.jd.util.Close;

import java.sql.*;

public class CartDAOImpl extends Bean implements CartDAO {

    //添加
    public void add(Integer uid, Integer pid) {
        try {
            conn=Close.getConn();
            sql = "insert into itable (uid,pid) values (?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,uid);
            preparedStatement.setInt(2,pid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(preparedStatement,conn);
        }
    }

    public boolean selectByPid(Integer pid) {
        try {
            conn=Close.getConn();
            sql = "select * from itable where pid =?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setObject(1,pid);
            resultSet = preparedStatement.executeQuery();
            sure = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(preparedStatement,conn);
        }
        return sure;
    }


    public boolean delete(Integer pid, Integer uid) {
        try {
            conn=Close.getConn();
            sql = "DELETE from itable where uid=? and pid=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setObject(1,uid);
            preparedStatement.setObject(2,pid);
            int i = preparedStatement.executeUpdate();
            if (i>0){
                sure=true;
            }else {
                sure=false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(preparedStatement,conn);
        }
        return sure;
    }

}
