package com.jd.dao.impl;

import com.jd.bean.Products;
import com.jd.dao.Bean;
import com.jd.dao.CommodityDAO;
import com.jd.util.Close;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommodityDAOImpl extends Bean implements CommodityDAO {
    public Connection conn = Close.getConn();

    //查看商品表，返回商品信息
    public List<Products> findProducts() {
        try {
            conn = Close.getConn();
            statement = conn.createStatement();
            sql="select * from products";

            resultSet = statement.executeQuery(sql);
            productList = new ArrayList<>();
            while (resultSet.next()){
                products=new Products();
                products.setPid(resultSet.getInt(1));
                products.setCid(resultSet.getInt(2));
                products.setPname(resultSet.getString(3));
                products.setPrice(resultSet.getDouble(4));
                productList.add(products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.release(resultSet,statement,conn);
        }
        return productList;
    }

    //添加商品
    public boolean insertGoods(String pid, String cid, String pname, double price) {
        try {
            conn=Close.getConn();
            sql = "insert into products (pid,cid,pname,price) values (?,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,pid);
            preparedStatement.setString(2,cid);
            preparedStatement.setString(3,pname);
            preparedStatement.setDouble(4,price);
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
    //修改商品
    public boolean updateGoods(Products products) {
        try {
            conn=Close.getConn();
            sql = "UPDATE products SET cid=?,pname=?,price=? WHERE pid=?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,products.getCid());
            preparedStatement.setString(2,products.getPname());
            preparedStatement.setDouble(3,products.getPrice());
            preparedStatement.setInt(4,products.getPid());
            int i = preparedStatement.executeUpdate();
            if (i>0){
                sure = true;
            }else {
                sure = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(preparedStatement,conn);
        }
        return sure;
    }

    public boolean deleteGoodsById(String pid) {
        try {
            conn=Close.getConn();
            sql = "DELETE FROM products where pid = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,pid);
            int i = preparedStatement.executeUpdate();

            if (i>0){
                sure = true;
            }else {
                sure = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(preparedStatement,conn);
        }
        return sure;
    }

    public List<Products> queryGoodsByUid(Integer uid) {
        try {
            conn=Close.getConn();
            sql = "SELECT * from products where pid in (select pid from itable where uid=?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1,uid);
            resultSet = preparedStatement.executeQuery();
            productList = new ArrayList<>();
            while (resultSet.next()){
                products =new Products();
                products.setPid(resultSet.getInt("pid"));
                products.setCid(resultSet.getInt("cid"));
                products.setPname(resultSet.getString("pname"));
                products.setPrice(resultSet.getDouble("price"));
                productList.add(products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            Close.release(resultSet,preparedStatement,conn);
        }

        return productList;
    }
}
