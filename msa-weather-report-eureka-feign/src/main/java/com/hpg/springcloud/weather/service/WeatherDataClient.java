package com.hpg.springcloud.weather.service;

import com.hpg.springcloud.weather.vo.City;
import com.hpg.springcloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Ponking
 * @ClassName CityClient
 * @date 2020/5/10--11:16
 **/
@FeignClient(value = "msa-weather-data-eureka",name = "msa-weather-data-eureka")
public interface WeatherDataClient {

    /**
     * 获取城市
     * @param cityId
     * @return
     */
    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId")String cityId);
}
