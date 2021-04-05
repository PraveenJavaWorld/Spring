package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.PersonalInfo;

public class PropertyEditorsTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Spring bean class obj
		PersonalInfo info = ctx.getBean("pInfo", PersonalInfo.class);
		System.out.println(info);

	}

}
