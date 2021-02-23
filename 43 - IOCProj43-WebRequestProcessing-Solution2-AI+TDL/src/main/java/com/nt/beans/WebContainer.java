package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebContainer implements ApplicationContextAware{
	
	private String beanId;
	private ApplicationContext ctx;
	
	public WebContainer(String beanId) {
		System.out.println("WebContainer::1-param constructor");
		this.beanId = beanId;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
		
	}
	
	public void handleRequest(String data) {
		System.out.println("WebConatiner::request came for processing "+data+"-->"+this.hashCode());
		//Aware Injection+Traditional Dependency Lookup code
		//get spring bean 
		RequestHandler handler = ctx.getBean(beanId,RequestHandler.class);
		handler.RequestProcessing(data);
		System.out.println("WebContainer::request handled "+data);
	}

	

}
