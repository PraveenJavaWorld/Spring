package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.EmployeeInfo;
import com.nt.service.IEmployeeMgmtService;

public class NamedParameterJDBCTemplateTest {

	public static void main(String[] args) {
		
		//create IOC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Spring Bean Class Obj
		IEmployeeMgmtService service = ctx.getBean("service", IEmployeeMgmtService.class);
		
		//Select Operations
		
		try {
			//call b.method
			EmployeeInfo info = service.fetchEmployeeById(2);
			System.out.println(info);
			
		}catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		try {
			//call b.method
			List<EmployeeInfo> info = service.fetchEmployeeByJob("DEVELOPER", "ANALYST", "SALESMAN");
			info.forEach(System.out::println);
		}catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//Insert Operations
		
		try {
			EmployeeInfo info = new EmployeeInfo();
			info.setEName("PRAVEEN");
			info.setJob("JAVA DEV");
			info.setSal(60000.0f);
			System.out.println(service.addEmployee(info));
		} catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();

	}

}
