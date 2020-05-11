package com.hpg.springcloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author Ponking
 * @ClassName EurekaServerApplication
 * @date 2020/5/9--18:09
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConfigClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigClientApplication.class,args);
    }
}
