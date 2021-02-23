package com.nt.beans;

public class RequestHandler {
	
	private static int count;
	
	public RequestHandler() {
		count++;
		System.out.println("RequestHandler::0-param constructor");
	}
	
	public void RequestProcessing(String data) {
		System.out.println("RequestHandler::processing the request "+data+"-->"+this.hashCode()+"->"+count);
	}

}
