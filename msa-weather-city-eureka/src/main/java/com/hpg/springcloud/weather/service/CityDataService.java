package com.hpg.springcloud.weather.service;

import com.hpg.springcloud.weather.vo.City;

import java.util.List;

/**
 * City Data Service
 * @author Ponking
 * @ClassName CityDataService
 * @date 2020/5/8--23:51
 **/
public interface CityDataService {

    /**
     * 获取city列表
     * @return
     * @throws Exception
     */
    List<City> listCity();


    /**
     * 获取city列表
     * @return
     * @throws Exception
     */
    List<City> listCityWithGuangDong();
}
