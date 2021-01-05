package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.FacultyInfo;

public class CollectionInjectionTest {

	public static void main(String[] args) {
		//create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//create spring bean obj
		FacultyInfo info = factory.getBean("info",FacultyInfo.class);
		System.out.println(info);

	}

}
