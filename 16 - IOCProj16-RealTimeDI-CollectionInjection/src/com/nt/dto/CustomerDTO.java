package com.nt.dto;

import java.io.Serializable;


public class CustomerDTO implements Serializable {
	
	private String cname;
	private String address;
	private float pAmt;
	private float rate;
	private float time;
	
	//getters and setters
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getpAmt() {
		return pAmt;
	}
	public void setpAmt(float pAmt) {
		this.pAmt = pAmt;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public float getTime() {
		return time;
	}
	public void setTime(float time) {
		this.time = time;
	}
	
	
	@Override
	public String toString() {
		return "CustomerDTO [cname=" + cname + ", address=" + address + ", pAmt=" + pAmt + ", rate=" + rate + ", time="
				+ time + "]";
	}
	
	

}
