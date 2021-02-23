package com.nt.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.BankController;
import com.nt.vo.CustomerVO;

public class RealTimeDITest {

	public static void main(String[] args) {
		
		//create IOC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
				
		//get controller class obj
		BankController controller = ctx.getBean("controller",BankController.class);
		//read inputs from EndUser
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Customer Details Below ::");
		System.out.println("Enter the Name");
		String name = sc.next();
		System.out.println("Enter the Address");
		String address = sc.next();
		System.out.println("Enter the Priciple Amount");
		String pAmt = sc.next();
		System.out.println("Enter the Rate Of Interest");
		String rate = sc.next();
		System.out.println("Enter the No.of Years");
		String time = sc.next();
		
		//create CustomerVO obj and assign above values
		CustomerVO vo = new CustomerVO();
		vo.setCname(name);
		vo.setAddress(address);
		vo.setPAmt(pAmt);
		vo.setRate(rate);
		vo.setTime(time);
		
		//invoke b.method
		try {
			String result = controller.processCustomer(vo);
			System.out.println(result);
		} catch (Exception e) {
			System.out.println("Problem in Customer Registration");
			e.printStackTrace(); 
		}
		
		sc.close();

	}

}
