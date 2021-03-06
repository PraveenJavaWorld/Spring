package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.WebContainer;

public class SolutionWithLMITest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get spring bean 
		WebContainer container = ctx.getBean("container",WebContainer.class);
		System.out.println(container.getClass()+" "+container.getClass().getSuperclass());
		//invoke methods
		container.handleRequest("hi");
		container.handleRequest("hello");
		container.handleRequest("bye");
		
		//close Container
		((AbstractApplicationContext) ctx).close();

	}

}
