package com.nt.beans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import lombok.Setter;

@Named("vote")
public class VoterEligibilityChecking {
	
	@Setter
	@Value("Praveen")
	private String name;
	@Setter
	@Value("23")
	private int age;
	private Date verificationDate;
	
	public VoterEligibilityChecking() {
		System.out.println("VoterEligibilityChecking::0-param constructor");
	}
	 @PostConstruct
	 public void myInit() {
		 //initialise the objects which r not participating in injections
		 verificationDate = new Date();
		 //check whether injected values are correct or not
		 if(name == null || age<=0 || age>=125)//validation logic
			 throw new IllegalArgumentException("invalid inputs");
	 }
	
	public String checking() {
		if(age<18)
			return "Mr."+ name+" u r not eligible for voting. Verified on "+verificationDate;
		else
			return "Mr."+name+" u r eligible for voting. Verified on "+verificationDate;
	}
	@PreDestroy
	public void myDestroy() {
		//nullify bean properties
		age=0;
		name=null;
		verificationDate = null;
	}

}
