package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Customer;

public class ConstructorInjection {

	public static void main(String[] args) {
		
		//Create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//Create XmlBeanDefinitionReader obj
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//load and parse spring bean cfg file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Spring bean class obj
		Customer cust = factory.getBean("cust",Customer.class);
		System.out.println("Object Data::"+cust);
		

	}

}
