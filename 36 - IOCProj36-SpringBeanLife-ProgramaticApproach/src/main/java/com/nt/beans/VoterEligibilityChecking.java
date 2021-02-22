package com.nt.beans;

import java.util.Date;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Setter;

public class VoterEligibilityChecking implements InitializingBean,DisposableBean{
	
	@Setter
	private String name;
	@Setter
	private int age;
	private Date verificationDate;
	
	public VoterEligibilityChecking() {
		System.out.println("VoterEligibilityChecking::0-param constructor");
	}
	 public void afterPropertiesSet() {
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
	
	public void destroy() {
		//nullify bean properties
		age=0;
		name=null;
		verificationDate = null;
	}

}
