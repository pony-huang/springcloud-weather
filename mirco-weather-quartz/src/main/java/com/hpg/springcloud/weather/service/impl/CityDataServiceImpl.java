package com.hpg.springcloud.weather.service.impl;

import com.hpg.springcloud.weather.service.CityDataService;
import com.hpg.springcloud.weather.util.CityServiceUtil;
import com.hpg.springcloud.weather.vo.City;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ponking
 * @ClassName CityDataServiceImpl
 * @date 2020/5/8--23:53
 **/
@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        String sql = "select * from city_info";
        List<City> list = CityServiceUtil.getList(City.class, sql);
        return list;
    }

    @Override
    public List<City> listCityWithGuangDong() throws Exception {
        String sql = "select * from city_info where province_en = 'guangdong'";
        List<City> list = CityServiceUtil.getList(City.class, sql);
        return list;
    }


}
