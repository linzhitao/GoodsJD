package com.jd.dao;

import com.jd.pojo.Products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Bean {
    public Connection conn;
    public Statement statement;
    public ResultSet resultSet;
    protected PreparedStatement preparedStatement;
    public boolean sure=true;
    protected String sql;
    public Products products;
    public List<Products> productList;
}
