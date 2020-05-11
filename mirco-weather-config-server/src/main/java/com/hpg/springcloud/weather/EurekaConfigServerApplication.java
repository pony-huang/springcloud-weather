package com.hpg.springcloud.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * @author Ponking
 * @ClassName EurekaServerApplication
 * @date 2020/5/9--18:09
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class EurekaConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigServerApplication.class,args);
    }
}
