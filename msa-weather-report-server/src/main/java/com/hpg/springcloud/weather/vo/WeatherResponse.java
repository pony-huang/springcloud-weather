package com.hpg.springcloud.weather.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 天气响应类型
 * @author Ponking
 * @ClassName WeatherResponse
 * @date 2020/5/8--16:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherResponse implements Serializable {
    private Weather data;
    private Integer status;
    private String desc;
}
