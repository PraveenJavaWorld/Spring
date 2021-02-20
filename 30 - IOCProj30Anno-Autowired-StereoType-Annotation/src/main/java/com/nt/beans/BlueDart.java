package com.nt.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bDart")
@Primary
@Scope("prototype")
public class BlueDart implements Courier {
	
	public BlueDart() {
		System.out.println("BlueDart::0-param constructor");
	}

	@Override
	public String deliver(int oid) {
		return "Delivering with Courier BlueDart having order id "+ oid;
	}

}
