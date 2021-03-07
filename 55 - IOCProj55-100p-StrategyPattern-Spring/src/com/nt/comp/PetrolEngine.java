package com.nt.comp;

import org.springframework.stereotype.Component;

@Component("pEngine")
public class PetrolEngine implements IEngine {

	@Override
	public void start() {
		System.out.println("Petrol Engine started---");

	}

	@Override
	public void stop() {
		System.out.println("Petrol Engine stopped---");

	}

}
