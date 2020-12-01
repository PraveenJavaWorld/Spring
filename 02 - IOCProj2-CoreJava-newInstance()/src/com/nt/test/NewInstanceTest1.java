package com.nt.test;

import java.lang.reflect.Constructor;

public class NewInstanceTest1 {

	public static void main(String[] args) throws Exception {
		
		//load class
		Class c = Class.forName(args[0]);
		//get all declared constructors
		Constructor cons[] = c.getDeclaredConstructors();
		//create object for 0-param constructor
		Object obj1 = cons[1].newInstance();
		System.out.println("Obj1 data::"+obj1);
		System.out.println("--------------------");
		//create object for two-param constructor
		Object obj2 = cons[0].newInstance(10,20);
		System.out.println("Obj2 data::"+obj2);
	}

}
