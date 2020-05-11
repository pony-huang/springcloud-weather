package com.hpg.springcloud.weather.service.impl;

import com.hpg.springcloud.weather.service.CityClient;
import com.hpg.springcloud.weather.service.WeatherDataClient;
import com.hpg.springcloud.weather.service.WeatherServiceReport;
import com.hpg.springcloud.weather.vo.Forecast;
import com.hpg.springcloud.weather.vo.Weather;
import com.hpg.springcloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ponking
 * @ClassName WeatherServiceReportImpl
 * @date 2020/5/9--12:54
 **/
@Service
public class WeatherServiceReportImpl implements WeatherServiceReport {

    @Autowired
    private WeatherDataClient weatherDataClient;


    @Override
    public Weather getDataByCityId(String cityId) {
        //TODO 改为由天气数据API微服务来提供
        WeatherResponse resp = weatherDataClient.getDataByCityId(cityId);
        return resp.getData();
    }
}
