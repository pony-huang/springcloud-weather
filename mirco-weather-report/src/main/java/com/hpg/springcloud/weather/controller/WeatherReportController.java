package com.hpg.springcloud.weather.controller;

import com.hpg.springcloud.weather.service.CityDataService;
import com.hpg.springcloud.weather.service.WeatherDataService;
import com.hpg.springcloud.weather.service.WeatherServiceReport;
import com.hpg.springcloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Ponking
 * @ClassName WeatherController
 * @date 2020/5/8--16:53
 **/
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private CityDataService CityDataService;

    @Autowired
    private WeatherServiceReport weatherServiceReport;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId")String cityId, Model model){
        model.addAttribute("title","广哥的天气预报");
        model.addAttribute("cityId",cityId);
        model.addAttribute("cityList",CityDataService.listCityWithGuangDong());
        model.addAttribute("report",weatherServiceReport.getDataByCityId(cityId));
        return new ModelAndView("weather/report","reportModel",model);
    }
}
