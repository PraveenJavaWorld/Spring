package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.beans.WishMessageGenerator;

@SpringBootApplication
public class Application {
	
	@Bean
	public LocalDateTime getTime() {
		return LocalDateTime.now();
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		//get spring bean class object
		WishMessageGenerator wmg = ctx.getBean("wmg", WishMessageGenerator.class);
		System.out.println("Wish Message is :: "+wmg.getWishMessage("Praveen"));
	}

}
