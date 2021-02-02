package com.nt.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class I18nTest {

	public static void main(String[] args) {
		
		//create Locale obj
		Locale locale = new Locale(args[0],args[1]);
		//create ResourceBundle obj
		ResourceBundle bundle = ResourceBundle.getBundle("com/nt/commons/App", locale);
		System.out.println(bundle.getString("wishMsg")+" "+bundle.getString("welcome.msg")+" "+bundle.getString("bye.msg"));

	}

}
