package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.model.ActorDetails;
import com.nt.service.IActorMgmtService;

public class SimpleJDBCInsertTest {

	public static void main(String[] args) {
		
		//create IOC Container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		//get Service obj
		IActorMgmtService service = ctx.getBean("service",IActorMgmtService.class);
		try {
			ActorDetails info = new ActorDetails();
			info.setId(2);
			info.setName("PAWAN KALYAN");
			info.setAddress("HYD");
			info.setCar("ROLLS ROYCE");
			info.setRemuneration(500000000.0f);
			//use dao
			System.out.println(service.addActor(info));
		}catch (DataAccessException dae) {
			dae.printStackTrace();
		}

	}

}
