package com.hpg.springcloud.weather.util;

import javax.annotation.processing.Filer;
import java.io.*;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ponking
 * @ClassName CityUtil
 * @date 2020/5/8--22:06
 **/
public class CityUtil {

    static Connection connection = null;
    static PreparedStatement statement = null;
    static int count = 0;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        FileReader fr = new FileReader("F:\\IntelliJ IDEA\\项目demo\\mirco-weather-quartz\\src\\main\\resources\\china-city-list.csv");
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        String line = null;
        connection = getConnection();
        while ((line = br.readLine()) != null) {
            String[] split = line.split("\\,", 13);
            split[0] = split[0].substring(2);
            List<String> list = Arrays.asList(split);
            insertData(connection, list);
            System.out.println("success..." + (++count));
//            list.get(list.size()-1).replace("\\,","");
//            System.out.println(list.size());
        }
    }

    private static void insertData(Connection connection, List<String> data) throws SQLException {
        String sql = "insert into city_info " +
                "(city_id,city_en,city_cn,country_code,country_en,country_cn,province_en,province_cn,admin_district_en,admin_district_cn,latitude,longitude,ad_code)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        statement = connection.prepareStatement(sql);
        for (int i = 0; i < data.size(); i++) {
            statement.setString(i + 1, data.get(i));
        }
        statement.executeUpdate();

    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/china_city?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }

    private static void close() {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
