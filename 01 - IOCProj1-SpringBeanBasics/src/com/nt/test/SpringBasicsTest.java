package com.nt.test;

import java.util.Date;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.nt.beans.WelcomeGreetings;

public class SpringBasicsTest {

	public static void main(String[] args) {
		
		//Locate and hold spring bean cfg file
		FileSystemResource res = new FileSystemResource("src/com/nt/cfgs/applicationContext.xml");
		//Create IOC Container(XmlBeanFactory)
		XmlBeanFactory factory = new XmlBeanFactory(res);
		//get spring class objects from Spring Container/IOC Container
		Date d = (Date)factory.getBean("dt");
		System.out.println("d obj data :: "+d);
		System.out.println("-----------");
		WelcomeGreetings greetings = (WelcomeGreetings)factory.getBean("wg");
		System.out.println(greetings.welcome("Praveen"));
		

	}

}
