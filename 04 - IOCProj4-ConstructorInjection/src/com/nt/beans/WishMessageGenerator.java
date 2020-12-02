package com.nt.beans;

import java.util.Date;

public class WishMessageGenerator {
	
	//bean property/attribute
	private Date date;//after injection it holds system date and time
	
	//Constructor for constructor injection
	public WishMessageGenerator(Date date) {
		System.out.println("WishMessageGenerator:: 1-param constructor");
		this.date = date;
	}
	
	//business method
	public String generateMessage(String user) {
		//get hour of the day
		int hour = date.getHours();//24 hour format
		if(hour<12)
			return "Good Morning::"+user;
		else if(hour<16)
			return "Good Afternoon::"+user;
		else if(hour<20)
			return "Good Evening::"+user;
		else
			return "Good Night ::"+user;
	}

}
