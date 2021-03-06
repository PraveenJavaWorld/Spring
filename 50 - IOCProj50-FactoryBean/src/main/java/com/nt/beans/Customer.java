package com.nt.beans;

public class Customer {
	
	private Product prod;
	
	public Customer(Product prod) {
		System.out.println("Customer:: 1-param constructor");
		this.prod = prod;
	}
	
	public void showProductDetails() {
		if(prod!=null)
			System.out.println(prod);
		else
			System.out.println("No Product is Received");
	}

}
