package com.hpg.springcloud.weather.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 昨日天气信息
 * @author Ponking
 * @ClassName Yesterday
 * @date 2020/5/8--16:26
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Yesterday implements Serializable {
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
