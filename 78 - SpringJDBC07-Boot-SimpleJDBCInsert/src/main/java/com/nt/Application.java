package com.nt;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.model.ActorDetails;
import com.nt.service.IActorMgmtService;

@SpringBootApplication
public class Application {
	
	@Autowired
	private DataSource ds;
	
	@Bean
	public SimpleJdbcInsert createSJI() {
		return new SimpleJdbcInsert(ds);
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		//get Service obj
				IActorMgmtService service = ctx.getBean("service",IActorMgmtService.class);
				try {
					ActorDetails info = new ActorDetails();
					info.setId(3);
					info.setName("PRABHAS");
					info.setAddress("HYD");
					info.setCar("LAMBORGINI");
					info.setRemuneration(500000000.0f);
					//use dao
					System.out.println(service.addActor(info));
				}catch (DataAccessException dae) {
					dae.printStackTrace();
				}
	}

}
