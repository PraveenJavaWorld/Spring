package com.nt.factory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.nt.comp.IEngine;
import com.nt.comp.Vehicle;

public class VehicleFactory {
	
	private static Properties props;
	static {
		try {
			//load properties file using InputStream
			InputStream is = new FileInputStream("src/com/nt/commons/strategy.properties");
			//Load properties info to java.util.Properties class object
			props = new Properties();
			props.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//static
	public static Vehicle getInstance() {
		Vehicle vehicle = null;
		try {
		//Load and create object of Dependent class by collecting class name from properties file
		String dependentClassName = props.getProperty("dependent.className");
		Class c = Class.forName(dependentClassName);
		IEngine engg = (IEngine) c.newInstance();
		//create object for target class (fixed)
		vehicle = new Vehicle();
		//assign dependent class object to target class object
		vehicle.setEngg(engg);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return vehicle;
	}

}
