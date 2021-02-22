package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.VoterEligibilityChecking;

public class SpringBeanLifeCycleTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Spring bean
		VoterEligibilityChecking vote = ctx.getBean("vote",VoterEligibilityChecking.class);
		System.out.println(vote.checking());
		//close Container
		((AbstractApplicationContext) ctx).close();
		

	}

}
