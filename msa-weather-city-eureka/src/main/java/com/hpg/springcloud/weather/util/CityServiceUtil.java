package com.hpg.springcloud.weather.util;

import com.hpg.springcloud.weather.vo.City;

import javax.xml.transform.Result;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ponking
 * @ClassName CityServiceUtil
 * @date 2020/5/8--23:45
 **/
public class CityServiceUtil {

    public static <T> T getInstance(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                T t = traverseData(clazz,columnCount,rsmd,rs);
                return t;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> getList(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                rsmd = rs.getMetaData();
                T t = traverseData(clazz,columnCount,rsmd,rs);
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static  <T>  T traverseData(Class<T> clazz,int columnCount,ResultSetMetaData rsmd,ResultSet rs) throws IllegalAccessException, InstantiationException, SQLException, NoSuchFieldException {
        T t = clazz.newInstance();
        for (int i = 0; i < columnCount; i++) {
            // 遍历每一个列获取列值
            Object columnVal = rs.getObject(i + 1);
            String columnLabel = rsmd.getColumnLabel(i + 1);
            columnLabel = StringUtil.underlineToHump(columnLabel);
            Field field = clazz.getDeclaredField(columnLabel);
            field.setAccessible(true);
            field.set(t, columnVal);
        }
        return t;
    }

    public static void main(String[] args) {
//        String sql = "select * from city_info where city_id = 101050801";
//        City city = getInstance(City.class, sql);
        String sql = "select * from city_info";
        List<City> cities = getList(City.class, sql);
        System.out.println(cities.size());
        for (City city : cities) {
            System.out.println(city);
        }
    }
}



