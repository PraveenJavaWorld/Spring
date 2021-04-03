package com.nt.test;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.nt.service.EmployeeMgmtServiceImpl;


public class JDBCTemplatesDirectMethodsTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get spring bean class obj
		EmployeeMgmtServiceImpl service = ctx.getBean("service",EmployeeMgmtServiceImpl.class);

		//Select Operations
		//use service
		try {
			System.out.println("Count is :: "+service.fetchEmployeeCount());
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("===================================");
		try {
			System.out.println("7499 Salary is :: "+service.fetchEmployeeSalaryByEno(7499));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("===================================");
		try {
			//System.out.println("Employee Details are :: "+service.fetchEmployeeDetailsByEno(7499));
			Map<String,Object> map = service.fetchEmployeeDetailsByEno(7499);
			map.entrySet().forEach(row->{
				System.out.println(row.getKey()+" "+row.getValue());
			});
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("===================================");
		try {
			//System.out.println("Employee Details are :: "+service.fetchEmployeeDetailsByDesignation("CLERK","MANAGER","ANALYST"));
			service.fetchEmployeeDetailsByDesignation("CLERK","MANAGER","ANALYST").forEach(map->{
				map.entrySet().forEach(row->{
					System.out.println(row.getKey()+" "+row.getValue());
				});
				System.out.println("\n");
			});
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("===================================");
		try {
			System.out.println("Employee Salary Ranging from 2000 to 4000 :: ");
			SqlRowSet rowset = service.fetchEmployeeDetailsBySalaryRange(2000, 4000);
			while(rowset.next()) {
				System.out.println(rowset.getInt(1)+" "+rowset.getString(2)+" "+rowset.getString(3)+" "+rowset.getFloat(4));
			}
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//Insert Operations
		System.out.println("=============================");
		try {
			System.out.println(service.registerEmployee("Praveen", "DEVELOPER", 40000.0f));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("=============================");
		try {
			System.out.println("Before Hike Salary is :: "+service.fetchEmployeeSalaryByEno(7499));
			System.out.println(service.hikeEmployeeSalary(7499, 10.0f));
			System.out.println("After Hike Salary is :: "+service.fetchEmployeeSalaryByEno(7499));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		System.out.println("=============================");
		try {
			System.out.println(service.fireEmployeeBySalaryRange(0f, 1100.0f));
		}
		catch (DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close IOC Container
		((AbstractApplicationContext) ctx).close();
		
	}
	

}
