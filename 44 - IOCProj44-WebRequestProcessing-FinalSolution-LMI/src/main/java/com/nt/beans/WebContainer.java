package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class WebContainer{
	
	
	public WebContainer() {
		System.out.println("WebContainer::0-param constructor"+this.getClass());
		
	}
	
	public abstract RequestHandler getHandler();
	
	
	public void handleRequest(String data) {
		System.out.println("WebConatiner::request came for processing "+data+"-->"+this.hashCode());
		//Aware Injection+Traditional Dependency Lookup code
		//get spring bean 
		RequestHandler handler = getHandler();
		handler.RequestProcessing(data);
		System.out.println("WebContainer::request handled "+data);
	}

	

}
