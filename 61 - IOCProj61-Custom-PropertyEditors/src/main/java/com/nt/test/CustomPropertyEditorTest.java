package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.BankLoanInterestCalculator;
import com.nt.beans.InterestAmountDetails;
import com.nt.editor.InterestAmountDetailsEditor;

public class CustomPropertyEditorTest {
	
	public static void main(String[] args) {
		//create IOC Container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		//using Anonymous Inner class
		/*//add new PERegisterar to IOC Container
		factory.addPropertyEditorRegistrar(new PropertyEditorRegistrar() {
			
			@Override
			public void registerCustomEditors(PropertyEditorRegistry registry) {
				registry.registerCustomEditor(InterestAmountDetails.class,new InterestAmountDetailsEditor());
				
			}
		});*/
		
		//using LAMBDA Expression
		//add new PERegisterar to IOC Container
		factory.addPropertyEditorRegistrar(registry ->{
			registry.registerCustomEditor(InterestAmountDetails.class, new InterestAmountDetailsEditor());
		});
		
		//get Target Spring Bean class obj
		BankLoanInterestCalculator blic = factory.getBean("blic",BankLoanInterestCalculator.class);
		System.out.println("Interest Amount :: "+blic.calculateInterestAmount());
		
	
	}
	
	

}
