package com.hpg.springcloud.weather.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ponking
 * @ClassName TestController
 * @date 2020/5/10--10:57
 **/
@RestController
public class TestController {

    @GetMapping("/hello")
    public String test(){
        return "Hello Work";
    }
}
