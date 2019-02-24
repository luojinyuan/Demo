package com.yuan.springboot.scheduledemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时轮询任务
 * @author luojy
 * @date 2019/2/24
 */
@Component
@Slf4j
public class ScheduleService {

    @Autowired
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    /**
     * 此方法为定时轮询任务
     * 其功能主要是每隔一段时间判断业务用消息通知的定时任务延迟队列剩余任务大小，
     * 可设置阈值，当队列未达到时可从数据库取数据送入队列
     */
    @Scheduled(cron = "*/30 * * * * ?")
    public void test(){
        log.info("30秒钟定时任务执行中...，此时线程名：{}", Thread.currentThread().getName());
        //判断消息通知延迟队列剩余任务个数，若小于100则加入新任务
        if(scheduledThreadPoolExecutor.getQueue().size() < 100){
            for(int i = 0; i < 10; i++){
                addScheduledTask("task" + i);
                log.info("任务task{}进入队列，此时消息通知定时任务队列还剩{}个任务", i, scheduledThreadPoolExecutor.getQueue().size());
            }
        }

    }

    /**
     * 消息通知队列加入新任务
     */
    private void addScheduledTask(String taskName){
        scheduledThreadPoolExecutor.schedule(new ScheduleTask(taskName), 2000, TimeUnit.MILLISECONDS);
    }


}
