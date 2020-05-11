package com.hpg.springcloud.weather.service;

import com.hpg.springcloud.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Ponking
 * @ClassName CityClient
 * @date 2020/5/10--11:16
 **/
@FeignClient(value = "msa-weather-city-eureka",name = "msa-weather-city-eureka")
public interface CityClient {

    /**
     * 获取城市
     * @return
     */
    @GetMapping("/cities")
    List<City> listCity();
}
