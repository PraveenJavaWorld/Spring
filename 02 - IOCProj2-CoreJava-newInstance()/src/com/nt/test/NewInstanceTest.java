package com.nt.test;

public class NewInstanceTest {

	public static void main(String[] args) throws Exception {
		
		//load class
		Class c = Class.forName(args[0]);
		//create Object
		Object obj = c.newInstance();
		System.out.println("data::"+obj);

	}

}
