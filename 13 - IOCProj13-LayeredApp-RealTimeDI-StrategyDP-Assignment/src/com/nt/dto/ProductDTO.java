package com.nt.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {
	
	private String pname;
	private String type;
	private float qty;
	private float basePrice;
	
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
	public float getQty() {
		return qty;
	}
	public void setQty(float qty) {
		this.qty = qty;
	}
	public float getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}
	
	
	@Override
	public String toString() {
		return "ProductDTO [pname=" + pname + ", type=" + type + ", qty=" + qty + ", basePrice=" + basePrice
				+ ", status=]";
	}
	
	
	

}
