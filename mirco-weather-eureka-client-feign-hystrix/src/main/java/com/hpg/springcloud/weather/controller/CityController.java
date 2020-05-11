package com.hpg.springcloud.weather.controller;

import com.hpg.springcloud.weather.serice.CityClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ponking
 * @ClassName CityController
 * @date 2020/5/10--10:31
 **/
@RestController
@RequestMapping
public class CityController {

    @Autowired
    private CityClient cityClient;

    @GetMapping("/cities")
    @HystrixCommand(fallbackMethod = "defaultCities")
    public String listCity() {
        //通过openFeign
//        int a = 10 / 0;
        String result = cityClient.listCity();
        return result;
    }


    public String defaultCities() {
        return "City DataServer is down...";
    }
}
