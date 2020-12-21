package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.Student;

public class ConstructorInjection {

	public static void main(String[] args) {
		
		//Create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//Create XmlBeanDefinitionReader obj
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//load and parse spring bean cfg file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//get Spring bean class obj
		Student st = factory.getBean("stud",Student.class);
		System.out.println("Object Data::"+st);
		System.out.println("========================");
		Student st1 = factory.getBean("stud1",Student.class);
		System.out.println("Object Data::"+st1);
		System.out.println("========================");
		Student st2 = factory.getBean("stud2",Student.class);
		System.out.println("Object Data::"+st2);

	}

}
