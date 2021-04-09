package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.model.PersonInfo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		
		//get Spring Bean Class Obj
		PersonInfo info = ctx.getBean("per",PersonInfo.class);
		System.out.println(info);
	}

}
