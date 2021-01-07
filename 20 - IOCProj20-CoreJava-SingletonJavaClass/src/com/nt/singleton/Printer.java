package com.nt.singleton;

public class Printer {
	
	//static reference variable
	private static Printer INSTANCE;
	//private constructor
	private Printer() {
		System.out.println("Printer::0-param constructor");
	}
	//public static factory method having singleton logic
	public static Printer getInstance(){
		if(INSTANCE==null)
			INSTANCE = new Printer();
		return INSTANCE;
	}

}
