package com.wangnan.backend.scheduler;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wangnan.backend.model.TaskDAO;
@Component
public class Scheduler1 {
//	@Scheduled(fixedDelay=5000)
	public void retrieveChange() {
		TaskDAO d = new TaskDAO();
		d.addTask("","");
		System.out.println("created the tasks");
	}
	
	public void sendDCN() {
		
	}
//	@Scheduled(fixedRate=5000)
//	public void myTask2() {
//		System.out.println("2. fixedRate - " + new Date());
//	}
//	@Scheduled(cron="*/5 * * * * MON-FRI")
//	public void myTask3() {
//		System.out.println("3. cron - " + new Date());
//	}

}
