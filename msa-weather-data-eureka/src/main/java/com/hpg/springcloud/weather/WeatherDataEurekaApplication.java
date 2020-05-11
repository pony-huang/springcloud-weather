package com.hpg.springcloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ponking
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WeatherDataEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherDataEurekaApplication.class, args);
    }

}
