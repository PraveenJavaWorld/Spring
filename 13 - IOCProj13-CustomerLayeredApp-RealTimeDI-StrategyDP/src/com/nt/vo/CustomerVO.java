package com.nt.vo;

public class CustomerVO {

	private String cname;
	private String address;
	private String pAmt;
	private String rate;
	private String time;

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

	public String getpAmt() {
		return pAmt;
	}

	public void setpAmt(String pAmt) {
		this.pAmt = pAmt;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "CustomerVO [cname=" + cname + ", address=" + address + ", pAmt=" + pAmt + ", rate=" + rate + ", time="
				+ time + "]";
	}

}
