package com.hpg.springcloud.weather.service;

/**
 * @author Ponking
 * @ClassName WeatherDataCollectionService
 * @date 2020/5/9--16:35
 **/
public interface WeatherDataCollectionService {

    /**
     * 根据城市Id同步天气
     * @param cityId
     */
    void syncDataByCityId(String cityId);
}
