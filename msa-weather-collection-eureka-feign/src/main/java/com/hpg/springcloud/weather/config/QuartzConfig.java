package com.hpg.springcloud.weather.config;

import com.hpg.springcloud.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ponking
 * @ClassName QuartzConfig
 * @date 2020/5/8--21:11
 **/
@Configuration
public class QuartzConfig {


    private static final int TIME = 1800;

    /**
     * JobDetail
     * Trigger
     */

    @Bean(name = "weatherDataSyncJobJobDetail")
    public JobDetail weatherDataSyncJobJobDetail(){
        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("WeatherDataSyncJob")
                .storeDurably().build();
    }

    @Bean
    public Trigger weatherDataSyncTrigger(){

        //withIntervalInSeconds 每隔x秒执行任务
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();
        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobJobDetail())
                .withIdentity("weatherDataSyncTrigger")
                .withSchedule(scheduleBuilder).build();
    }
}
