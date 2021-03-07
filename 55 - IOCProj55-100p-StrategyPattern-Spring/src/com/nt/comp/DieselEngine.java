package com.nt.comp;

import org.springframework.stereotype.Component;

@Component("dEngine")
public class DieselEngine implements IEngine {

	@Override
	public void start() {
		System.out.println("Diesel Engine started---");

	}

	@Override
	public void stop() {
		System.out.println("Diesel Engine stopped---");

	}

}
