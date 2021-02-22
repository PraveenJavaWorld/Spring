package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.VoterEligibilityChecking;

public class SpringBeanLifeCycleTest_BF {

	public static void main(String[] args) {
		
		//create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//create XmlBeanDefinitionReader obj
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//load and parse xml file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Spring bean
		VoterEligibilityChecking vote = factory.getBean("vote",VoterEligibilityChecking.class);
		System.out.println(vote.checking());
		

	}

}
