package com.nt.beans;

public class Customer {

	private int cno;
	private String cname;
	private String cadd;
	private float billAmt;

	public Customer(int cno, String cname, String cadd, float billAmt) {
		System.out.println("Customer::4-param constructor");
		this.cno = cno;
		this.cname = cname;
		this.cadd = cadd;
		this.billAmt = billAmt;
	}

	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", cadd=" + cadd + ", billAmt=" + billAmt + "]";
	}

}
