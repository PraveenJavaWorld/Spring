package com.nt.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WishMessageGenerator;

public class ConstructorInjectionTest {

	public static void main(String[] args) {
		
		//hold and locate the spring bean cfg file
		FileSystemResource res = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//create IOC Container
		XmlBeanFactory factory = new XmlBeanFactory(res);
		//get target Spring Bean class object
		WishMessageGenerator generator = (WishMessageGenerator) factory.getBean("wmg");
		//invoke b.method
		System.out.println("Result :: "+generator.generateMessage(" Praveen"));

	}

}
