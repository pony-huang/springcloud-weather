package com.hpg.springcloud.weather.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ponking
 * @ClassName TestController
 * @date 2020/5/10--10:57
 **/
@RestController
public class TestController {


    @Value("${author}")
    private String author;


    @GetMapping("/author")
    public String contextLoad(){
        return author;
    }

}
