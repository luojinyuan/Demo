package com.yuan.springboot.scheduledemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author luojy
 * @date 2019/2/24
 */
@Configuration
public class ScheduleConfig implements SchedulingConfigurer{

    /**
     * 配置定时轮询任务线程池大小为5
     * @param taskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(5));
    }

    /**
     * 设置消息通知任务线程池大小为5
     * @return
     */
    @Bean
    public ScheduledThreadPoolExecutor getScheduledThreadPoolExecutor(){
        return new ScheduledThreadPoolExecutor(5);
    }

}
