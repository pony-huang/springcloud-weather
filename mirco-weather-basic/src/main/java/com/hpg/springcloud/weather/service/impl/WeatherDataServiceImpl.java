package com.hpg.springcloud.weather.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hpg.springcloud.weather.service.WeatherDataService;
import com.hpg.springcloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Ponking
 * @ClassName WeatherDataServiceImpl
 * @date 2020/5/8--16:34
 **/
@Component
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI+"citykey="+cityId;
        return doGetWeather(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI+"city="+cityName;
        return doGetWeather(uri);
    }


    private WeatherResponse doGetWeather(String uri){
        ResponseEntity<String> responseString = restTemplate.getForEntity(uri,String.class);

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = null;
        String responseBody = null;

        if(responseString.getStatusCodeValue() == 200){
            responseBody = responseString.getBody();
        }
        try {
            weatherResponse = mapper.readValue(responseBody,WeatherResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return weatherResponse;
    }
}
