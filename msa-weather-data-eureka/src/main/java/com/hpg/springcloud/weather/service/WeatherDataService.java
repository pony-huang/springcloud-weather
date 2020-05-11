package com.hpg.springcloud.weather.service;

import com.hpg.springcloud.weather.vo.WeatherResponse;

/**
 * @author Ponking
 * @ClassName WeatherDataService
 * @date 2020/5/8--16:33
 **/
public interface WeatherDataService {

    /**
     * 根据城市Id查询天气数据
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);


    /**
     * 根据城市名称查询天气数据
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

}
