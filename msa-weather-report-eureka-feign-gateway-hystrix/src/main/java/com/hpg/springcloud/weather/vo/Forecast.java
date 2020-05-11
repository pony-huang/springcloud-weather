package com.hpg.springcloud.weather.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 未来的天气信息
 * @author Ponking
 * @ClassName Forecast
 * @date 2020/5/8--16:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forecast implements Serializable {
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
