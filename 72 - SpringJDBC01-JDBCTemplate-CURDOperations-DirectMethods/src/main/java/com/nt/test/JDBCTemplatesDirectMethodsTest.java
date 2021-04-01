package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmployeeMgmtServiceImpl;


public class JDBCTemplatesDirectMethodsTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get spring bean class obj
		EmployeeMgmtServiceImpl service = ctx.getBean("service",EmployeeMgmtServiceImpl.class);
		//use dao
		System.out.println("Count is :: "+service.fetchEmployeeCount());
	}

}
