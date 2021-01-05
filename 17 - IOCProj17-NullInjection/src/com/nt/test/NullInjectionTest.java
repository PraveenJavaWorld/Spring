package com.nt.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.PersonalInfo;

public class NullInjectionTest {

	public static void main(String[] args) {
		
		//create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//create Spring bean class obj
		PersonalInfo rajaInfo = factory.getBean("rajaInfo",PersonalInfo.class);
		System.out.println(rajaInfo);
		PersonalInfo rameshInfo = factory.getBean("rameshInfo",PersonalInfo.class);
		System.out.println(rameshInfo);

	}

}
