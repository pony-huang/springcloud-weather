package com.hpg.springcloud.weather.controller;

import com.hpg.springcloud.weather.service.CityDataService;
import com.hpg.springcloud.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ponking
 * @ClassName CityController
 * @date 2020/5/9--17:28
 **/
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity(){
        return cityDataService.listCityWithGuangDong();
    }
}
