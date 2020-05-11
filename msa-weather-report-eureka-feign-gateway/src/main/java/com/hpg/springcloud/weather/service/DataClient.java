package com.hpg.springcloud.weather.service;

import com.hpg.springcloud.weather.vo.City;
import com.hpg.springcloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Ponking
 * @ClassName DataClient
 * @date 2020/5/10--16:35
 **/
@FeignClient(value = "msa-weather-eureka-client-zuul",name = "msa-weather-eureka-client-zuul")
public interface DataClient {
    /**
     * 获取城市
     * @return
     */
    @GetMapping("/city/cities")
    List<City> listCity();

    /**
     * 获取城市
     * @param cityId
     * @return
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId")String cityId);
}
