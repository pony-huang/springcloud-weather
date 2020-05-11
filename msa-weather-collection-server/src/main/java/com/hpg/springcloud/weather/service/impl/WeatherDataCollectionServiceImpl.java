package com.hpg.springcloud.weather.service.impl;

import com.hpg.springcloud.weather.service.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author Ponking
 * @ClassName WeatherDataCollectionServiceImpl
 * @date 2020/5/9--16:37
 **/
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {


    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    /**
     * 过期时间
     */
    private static final long TIME_OUT = 1800L;


    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    /**
     * 把天气数据放在缓存中
     * @param uri
     */
    private void saveWeatherData(String uri) {
        String key = uri;
        String responseBody = null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();

        ResponseEntity<String> responseString = restTemplate.getForEntity(uri, String.class);
        if(responseString.getStatusCodeValue() == 200){
            responseBody = responseString.getBody();
        }
        //数据写入缓存
        ops.set(key, responseBody, TIME_OUT, TimeUnit.SECONDS);

    }
}
