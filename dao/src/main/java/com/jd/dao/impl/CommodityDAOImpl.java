package com.jd.dao.impl;

import com.jd.bean.Products;
import com.jd.dao.CommodityDAO;
import com.jd.util.Close;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommodityDAOImpl implements CommodityDAO {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private boolean sure=false;
    private Products products;
    private List<Products> productList;
    private String sql;

    //查看商品表，返回商品信息
    public List<Products> findProducts() {
        try {
            conn = Close.getConn();
            st = conn.createStatement();
            sql="select * from products";

            rs = st.executeQuery(sql);
            productList = new ArrayList<Products>();
            while (rs.next()){
                products=new Products();
                products.setPid(rs.getInt(1));
                products.setCid(rs.getInt(2));
                products.setPname(rs.getString(3));
                products.setPrice(rs.getDouble(4));
                productList.add(products);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.release(rs,st,conn);
        }
        return productList;
    }
}
