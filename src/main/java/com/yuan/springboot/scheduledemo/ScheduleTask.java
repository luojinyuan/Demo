package com.yuan.springboot.scheduledemo;

import lombok.extern.slf4j.Slf4j;


/**
 * 消息通知任务
 * @author luojy
 * @date 2019/2/24
 */
@Slf4j
public class ScheduleTask implements Runnable{

    private String taskName;

    public ScheduleTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        log.info("消息通知定时任务{}执行...，当前线程：{}", taskName, Thread.currentThread().getName());
    }
}
