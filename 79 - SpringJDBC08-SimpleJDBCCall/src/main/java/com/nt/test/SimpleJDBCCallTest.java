package com.nt.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.ILoginMgmtService;

import org.springframework.context.ApplicationContext;

public class SimpleJDBCCallTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get service obj
		ILoginMgmtService service = ctx.getBean("service", ILoginMgmtService.class);
		//invoke methods
		System.out.println(service.login("praveen","1234"));
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
