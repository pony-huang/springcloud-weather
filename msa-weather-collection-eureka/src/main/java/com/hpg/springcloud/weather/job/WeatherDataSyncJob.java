package com.hpg.springcloud.weather.job;

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

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Weather Data Sync Job...");
        List<City> cityList = null;

        //获取城市Id列表

        try {
            //TODO 改为由城市数据API微服务来提供数据
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101282104");
            cityList.add(city);
        } catch (Exception e) {
            log.error("Exception !",e);
        }
        // 遍历城市Id获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            dataCollectionService.syncDataByCityId(cityId);
            log.info("Weather Data Sync Job,cityId: "+cityId);
        }
        log.info("Weather Data Sync Job done!!!");
    }
}
