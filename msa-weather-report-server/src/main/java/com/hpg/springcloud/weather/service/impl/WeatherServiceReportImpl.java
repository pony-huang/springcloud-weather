package com.hpg.springcloud.weather.service.impl;

import com.hpg.springcloud.weather.service.WeatherServiceReport;
import com.hpg.springcloud.weather.vo.Forecast;
import com.hpg.springcloud.weather.vo.Weather;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ponking
 * @ClassName WeatherServiceReportImpl
 * @date 2020/5/9--12:54
 **/
@Service
public class WeatherServiceReportImpl implements WeatherServiceReport {



    @Override
    public Weather getDataByCityId(String cityId) {
        //TODO 改为由天气数据API微服务来提供
        Weather data = new Weather();
        data.setAqi("91");
        data.setCity("深圳");
        data.setWendu("22");
        data.setGanmao("容易感冒!多穿衣服!");
        List<Forecast> forecastList = new ArrayList<>();
        Forecast forecast = new Forecast();
        forecast.setDate("29日星期天");
        forecast.setType("下雨天");
        forecast.setHigh("高温21度");
        forecast.setLow("低温11度");
        forecast.setFengxiang("无风");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("30日星期天");
        forecast.setType("下雨天");
        forecast.setHigh("高温21度");
        forecast.setLow("低温11度");
        forecast.setFengxiang("无风");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("31日星期天");
        forecast.setType("下雨天");
        forecast.setHigh("高温21度");
        forecast.setLow("低温11度");
        forecast.setFengxiang("无风");
        forecastList.add(forecast);


        forecast = new Forecast();
        forecast.setDate("1日星期天");
        forecast.setType("下雨天");
        forecast.setHigh("高温21度");
        forecast.setLow("低温11度");
        forecast.setFengxiang("无风");
        forecastList.add(forecast);

        forecast = new Forecast();
        forecast.setDate("2日星期天");
        forecast.setType("下雨天");
        forecast.setHigh("高温21度");
        forecast.setLow("低温11度");
        forecast.setFengxiang("无风");
        forecastList.add(forecast);


        data.setForecast(forecastList);

        return data;
    }
}
