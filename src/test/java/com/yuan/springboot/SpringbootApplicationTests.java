package com.yuan.springboot;

import com.yuan.springboot.scheduledemo.ScheduleTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() throws InterruptedException {
		scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);
		String taskName = null;
		for (int i = 0; i < 10; i++){
			taskName = "task" + i;
			scheduledThreadPoolExecutor.schedule(new ScheduleTask(taskName), 1000, TimeUnit.MILLISECONDS);
		}

		Thread.sleep(10000);
	}


}
