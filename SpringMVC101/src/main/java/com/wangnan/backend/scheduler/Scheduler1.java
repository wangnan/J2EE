package com.wangnan.backend.scheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class Scheduler1 {
	@Scheduled(fixedDelay=5000)
	public void myTask() {
		System.out.println(new Date());
	}
}
