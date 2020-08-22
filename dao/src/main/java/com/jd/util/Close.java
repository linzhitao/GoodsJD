package com.jd.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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

    public static void release(ResultSet rs, Statement st, Connection conn){
        closeRs(rs);
        closeSt(st);
        closeConn(conn);
    }

    public static void release(Statement st,Connection conn){
        closeSt(st);
        closeConn(conn);
    }

    private static void closeRs(ResultSet rs){
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            rs =null;
        }
    }

    private static void closeSt(Statement st){
        try {
            if(st != null){
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            st = null;
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
