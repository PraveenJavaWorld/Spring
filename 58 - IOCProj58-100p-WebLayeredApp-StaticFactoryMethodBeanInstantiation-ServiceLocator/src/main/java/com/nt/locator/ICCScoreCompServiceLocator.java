package com.nt.locator;

import com.nt.external.ICCScoreCompImpl;
import com.nt.external.IICCScoreComp;


public class ICCScoreCompServiceLocator {

	
	public static IICCScoreComp getInstance() {
		//Actually we should write jndi lookup code for getting Extenal Comp ref.. since we take Extenal Comp as 
		//normal java class for simplification , So we are going to create object for that class directly
		IICCScoreComp comp = new ICCScoreCompImpl();
		return comp;
	}

	

}
