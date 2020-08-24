package com.jd.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Close {
    static String driverClass = null;
    static String url = null;
    static String username = null;
    static String password = null;
    static{
        try {
            Properties properties = new Properties();
            FileInputStream fileinput = new FileInputStream("F:\\goods\\dao\\src\\main\\resources\\db.properties");
            //InputStream is = Close.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(fileinput);
            driverClass = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        Connection conn = null;
        try {
            Class.forName(driverClass);
            conn = DriverManager.getConnection(url,username,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void release(ResultSet resultSet, Statement statement, Connection conn){
        closeRs(resultSet);
        closeSt(statement);
        closeConn(conn);
    }

    public static void release(Statement statement,Connection conn){
        closeSt(statement);
        closeConn(conn);
    }

    private static void closeRs(ResultSet resultSet){
        try {
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            resultSet =null;
        }
    }

    private static void closeSt(Statement statement){
        try {
            if(statement != null){
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            statement = null;
        }
    }

    private static void closeConn(Connection conn){
        try {
            if(conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conn = null;
        }
    }
}
