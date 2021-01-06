package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.WishMessageGenerator;

public class SetterInjectionTest {

	public static void main(String[] args) {
		
		
		//create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get target Spring Bean class object
		WishMessageGenerator generator = factory.getBean("wishMessageGenerator",WishMessageGenerator.class);
		WishMessageGenerator generator1 = factory.getBean("wmg1",WishMessageGenerator.class);
		WishMessageGenerator generator2 = factory.getBean("wmg2",WishMessageGenerator.class);
		System.out.println(generator.hashCode()+" "+generator1.hashCode()+" "+generator2.hashCode());
		WishMessageGenerator generator3 = factory.getBean("msg1",WishMessageGenerator.class);
		WishMessageGenerator generator4 = factory.getBean("msg2",WishMessageGenerator.class);
		WishMessageGenerator generator5 = factory.getBean("msg3",WishMessageGenerator.class);
		WishMessageGenerator generator6 = factory.getBean("msg4",WishMessageGenerator.class);
		System.out.println(generator3.hashCode()+" "+generator4.hashCode()+" "+generator5.hashCode()+" "+generator6.hashCode());
		//invoke b.method
		System.out.println("Result :: "+generator.generateMessage("Praveen"));

	}//main

}//class
