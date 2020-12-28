package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.controller.MainController;
import com.nt.vo.ProductVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		
		//create IOC container
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//create XmlBeanDefinitionReader obj
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//load and parse spring bean cfg file
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		
		//get controller obj
		MainController controller = factory.getBean("controller", MainController.class);
		//read inputs from EndUser
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product Details Below ::");
		System.out.println("Enter the Name");
		String name = sc.next();
		System.out.println("Enter the Type");
		String type = sc.next();
		System.out.println("Enter the QTY");
		String qty = sc.next();
		System.out.println("Enter the Base Price");
		String basePrice = sc.next();
		
		//create ProductVO obj
		ProductVO vo = new ProductVO();
		vo.setPname(name);
		vo.setType(type);
		vo.setQty(qty);
		vo.setBasePrice(basePrice);
		
		//invoke b.method
		try {
			String result = controller.processProduct(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Problem in Product Registration");
			e.printStackTrace();
		}
		
		sc.close();

	}

}
