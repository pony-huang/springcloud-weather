package com.hpg.springcloud.weather.job;

import com.hpg.springcloud.weather.service.CityClient;
import com.hpg.springcloud.weather.service.WeatherDataCollectionService;
import com.hpg.springcloud.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ponking
 * @ClassName WeatherDataSyncJob
 * @date 2020/5/8--21:10
 **/
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private WeatherDataCollectionService dataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext){
        log.info("Weather Data Sync Job...");
        List<City> cityList = cityClient.listCity();

        // 遍历城市Id获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            dataCollectionService.syncDataByCityId(cityId);
            log.info("Weather Data Sync Job,cityId: "+cityId);
        }
        log.info("Weather Data Sync Job done!!!");
    }
}
