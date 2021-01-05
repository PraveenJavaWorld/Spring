package com.nt.beans;

import java.util.Date;

public class PersonalInfo {
	
	private String pname;
	private String address;
	private Date dob;
	private Date doj;
	private Date dom;
	
	
	public PersonalInfo(String pname, String address, Date dob, Date doj, Date dom) {
		System.out.println("PersonalInfo::5-param constructor");
		this.pname = pname;
		this.address = address;
		this.dob = dob;
		this.doj = doj;
		this.dom = dom;
	}


	@Override
	public String toString() {
		return "PersonalInfo [pname=" + pname + ", address=" + address + ", dob=" + dob + ", doj=" + doj + ", dom="
				+ dom + "]";
	}
	
	

}
