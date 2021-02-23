package com.nt.beans;

public interface WebContainer{
	
	
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
