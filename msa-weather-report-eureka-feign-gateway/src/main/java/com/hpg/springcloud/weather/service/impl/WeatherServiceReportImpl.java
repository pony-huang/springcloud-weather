package com.hpg.springcloud.weather.service.impl;

import com.hpg.springcloud.weather.service.DataClient;
import com.hpg.springcloud.weather.service.WeatherServiceReport;
import com.hpg.springcloud.weather.vo.Weather;
import com.hpg.springcloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ponking
 * @ClassName WeatherServiceReportImpl
 * @date 2020/5/9--12:54
 **/
@Service
public class WeatherServiceReportImpl implements WeatherServiceReport {

    @Autowired
    private DataClient dataClient;


    @Override
    public Weather getDataByCityId(String cityId) {
        //由天气数据API微服务来提供
        WeatherResponse resp = dataClient.getDataByCityId(cityId);
        return resp.getData();
    }
}
