package com.nt.beans;

import javax.inject.Named;

@Named("dhl")
public class DHL implements Courier {
	
	public DHL() {
		System.out.println("DHL::0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "Delivering with Courier DHL having order id "+ oid;
	}

}
