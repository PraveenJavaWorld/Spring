package com.nt.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class IOCContainerMonitoringListener implements ApplicationListener{

	private long start,end;
	
	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		
		if(event.toString().contains("RefreshedEvent")) {
			start = System.currentTimeMillis();
		}
		else if(event.toString().contains("ClosedEvent")) {
			end = System.currentTimeMillis();
		}
		System.out.println("IOC Container Runned for :: "+(end-start)+"ms");
		
	}

	
}
