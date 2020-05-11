package com.hpg.springcloud.weather.serice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ponking
 * @ClassName CityClient
 * @date 2020/5/10--10:30
 **/
@FeignClient(value = "MSA-WEATHER-CITY-EUREKA",name = "MSA-WEATHER-CITY-EUREKA")
public interface CityClient {

    /**
     * 测试
     * @return
     */
    @GetMapping("/cities")
    String listCity();
}
