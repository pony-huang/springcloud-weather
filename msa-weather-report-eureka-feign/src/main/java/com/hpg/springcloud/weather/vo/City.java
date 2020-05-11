package com.hpg.springcloud.weather.vo;

import lombok.Data;

/**
 * @author Ponking
 * @ClassName City
 * @date 2020/5/8--22:07
 **/
@Data
public class City {
    private String cityId;
    private String cityEn;
    private String cityCn;
    private String countryCode;
    private String countryEn;
    private String countryCn;
    private String provinceEn;
    private String provinceCn;
    private String adminDistrictEn;
    private String adminDistrictCn;
    private String latitude;
    private String longitude;
    private String adCode;
}
