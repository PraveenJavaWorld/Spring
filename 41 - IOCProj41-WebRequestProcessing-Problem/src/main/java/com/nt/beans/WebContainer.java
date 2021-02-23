package com.nt.beans;

public class WebContainer {
	
	private RequestHandler handler;
	
	public WebContainer(RequestHandler handler) {
		this.handler = handler;
		System.out.println("WebContainer::1-param container");
	}
	
	public void handleRequest(String data) {
		System.out.println("WebConatiner::request came for processing "+data+"-->"+this.hashCode());
		handler.RequestProcessing(data);
		System.out.println("WebConatiner::request handled "+data);
	}

}
