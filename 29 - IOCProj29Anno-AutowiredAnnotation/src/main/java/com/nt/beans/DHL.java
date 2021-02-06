package com.nt.beans;

public class DHL implements Courier {
	
	public DHL() {
		System.out.println("DHL::0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "Delivering with Courier DHL having order id "+ oid;
	}

}
