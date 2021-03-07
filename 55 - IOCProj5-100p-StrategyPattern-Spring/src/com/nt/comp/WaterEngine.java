package com.nt.comp;

import org.springframework.stereotype.Component;

@Component("wEngine")
public class WaterEngine implements IEngine {

	@Override
	public void start() {
		System.out.println("Water Engine started---");

	}

	@Override
	public void stop() {
		System.out.println("Water Engine stopped---");

	}

}
