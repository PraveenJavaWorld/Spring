package com.nt.beans;

import java.util.Date;

import lombok.Setter;

public class VoterEligibilityChecking {
	
	@Setter
	private String name;
	@Setter
	private int age;
	private Date verificationDate;
	
	public VoterEligibilityChecking() {
		System.out.println("VoterEligibilityChecking::0-param constructor");
	}
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
	
	public void myDestroy() {
		//nullify bean properties
		age=0;
		name=null;
		verificationDate = null;
	}

}
