package com.hpg.springcloud.weather.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息
 * @author Ponking
 * @ClassName Weather
 * @date 2020/5/8--16:23
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weather implements Serializable {
    private Yesterday yesterday;
    private String city;
    private String aqi;
    private List<Forecast> forecast;
    private String ganmao;
    private String wendu;
}
