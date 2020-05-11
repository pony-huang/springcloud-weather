package com.hpg.springcloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * @author Ponking
 * @ClassName EurekaServerApplication
 * @date 2020/5/9--18:09
 **/
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker //启用断路器
public class EurekaClientFeignHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientFeignHystrixApplication.class, args);
    }
}
