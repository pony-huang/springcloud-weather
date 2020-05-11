package com.hpg.springcloud.weather.service;

import com.hpg.springcloud.weather.vo.City;
import com.hpg.springcloud.weather.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ponking
 * @ClassName DataClientFallback
 * @date 2020/5/11--15:15
 **/
@Component
public class DataClientFallback implements DataClient {

    @Override
    public List<City> listCity() {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("101280601","深圳"));
        cityList.add(new City("101280301","惠州"));
        return cityList;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}
