package com.hpg.springcloud.weather.job;

import com.hpg.springcloud.weather.service.CityDataService;
import com.hpg.springcloud.weather.service.WeatherDataService;
import com.hpg.springcloud.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author Ponking
 * @ClassName WeatherDataSyncJob
 * @date 2020/5/8--21:10
 **/
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Weather Data Sync Job...");
        List<City> cityList = null;

        //获取城市Id列表
        try {
            cityList = cityDataService.listCityWithGuangDong();
        } catch (Exception e) {
            log.error("Exception !",e);
        }
        // 遍历城市Id获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            weatherDataService.syncDateByCityId(cityId);
            log.info("Weather Data Sync Job,cityId: "+cityId);
        }
        log.info("Weather Data Sync Job done!!!");
    }
}
