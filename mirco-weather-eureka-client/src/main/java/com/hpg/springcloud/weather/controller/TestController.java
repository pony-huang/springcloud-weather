package com.hpg.springcloud.weather.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ponking
 * @ClassName TestController
 * @date 2020/5/10--10:57
 **/
@RestController
public class TestController {


    @Value("${server.port}")
    private Integer port;


    @GetMapping("/hello")
    public String hello(){
        return "Hello Work port:"+port;
    }

    @GetMapping("/hi")
    public String hi(){
        return "Hello Work port:"+port;
    }
}
