package com.hpg.springcloud.weather.util;

import java.io.InputStream;
import java.sql.*;

/**
 * 操作数据库的工具类
 *
 * @author Ponking
 * @ClassName JDBCUtils
 * @date 2020/5/9--0:00
 **/
public class JDBCUtils {

    /**
     * @return
     * @throws Exception
     * @Description 获取数据库的连接
     * @author shkstart
     * @date 上午9:11:23
     */
    public static Connection getConnection() throws Exception {
        // 1.读取配置文件中的4个基本信息
        String url = "jdbc:mysql://localhost:3306/china_city?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";

        // 2.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 3.获取连接
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    /**
     * @param conn
     * @param ps
     * @Description 关闭连接和Statement的操作
     * @author shkstart
     * @date 上午9:12:40
     */
    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param conn
     * @param ps
     * @param rs
     * @Description 关闭资源操作
     * @author shkstart
     * @date 上午10:21:15
     */
    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
