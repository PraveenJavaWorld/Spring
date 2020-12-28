package com.nt.vo;

public class ProductVO {
	
	private String pname;
	private String type;
	private String qty;
	private String basePrice;
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(String basePrice) {
		this.basePrice = basePrice;
	}
	
	@Override
	public String toString() {
		return "ProductVO [pname=" + pname + ", type=" + type + ", qty=" + qty + ", basePrice=" + basePrice + "]";
	}
	
	
	

}
