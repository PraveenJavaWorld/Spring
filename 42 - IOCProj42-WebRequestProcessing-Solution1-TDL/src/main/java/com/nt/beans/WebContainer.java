package com.nt.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer {
	
	private String beanId;
	
	public WebContainer(String beanId) {
		System.out.println("WebContainer::1-param constructor");
		this.beanId = beanId;
	}
	
	public void handleRequest(String data) {
		System.out.println("WebConatiner::request came for processing "+data+"-->"+this.hashCode());
		//Traditional Dependency Lookup code
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get spring bean 
		RequestHandler handler = ctx.getBean(beanId,RequestHandler.class);
		handler.RequestProcessing(data);
		System.out.println("WebConatiner::request handled "+data);
	}

}
