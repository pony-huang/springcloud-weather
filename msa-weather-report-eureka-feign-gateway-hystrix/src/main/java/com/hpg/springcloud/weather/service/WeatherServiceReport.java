package com.hpg.springcloud.weather.service;

import com.hpg.springcloud.weather.vo.Weather;

/**
 * @author Ponking
 * @ClassName WeatherServiceReport
 * @date 2020/5/9--12:53
 **/
public interface WeatherServiceReport {

    /**
     * 根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);
}
