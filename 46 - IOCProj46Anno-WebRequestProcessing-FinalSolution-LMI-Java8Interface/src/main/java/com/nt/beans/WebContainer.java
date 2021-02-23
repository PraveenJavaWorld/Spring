package com.nt.beans;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("container")
@Scope("singleton")
public interface WebContainer{
	
	@Lookup
	public RequestHandler getHandler();
	
	
	default void handleRequest(String data) {
		System.out.println("WebConatiner::request came for processing "+data+"-->"+this.hashCode());
		//Aware Injection+Traditional Dependency Lookup code
		//get spring bean 
		RequestHandler handler = getHandler();
		handler.RequestProcessing(data);
		System.out.println("WebContainer::request handled "+data);
	}

	

}
