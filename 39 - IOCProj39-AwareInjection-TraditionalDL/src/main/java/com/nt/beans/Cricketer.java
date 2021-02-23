package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Cricketer implements ApplicationContextAware{
	
	private String name;
	private int jerseyNo;
	private String beanId;
	private ApplicationContext ctx;
	
	public Cricketer() {
		System.out.println("Cricketer::0-param constructor");
	}
	
	public void setName(String name) {
		System.out.println("Cricketer.setName()");
		this.name = name;
	}
	public void setJerseyNo(int jerseyNo) {
		System.out.println("Cricketer.setJerseyNo()");
		this.jerseyNo = jerseyNo;
	}
	
	public void setBeanId(String beanId) {
		System.out.println("Cricketer.setBeanId()");
		this.beanId = beanId;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("Cricketer.setApplicationContext()");
		this.ctx = ctx;		
	}

	public void bowling() {
		System.out.println("Mr."+name+" with Jersey Number "+jerseyNo+" is Bowling");
	}
	
	public void fielding() {
		System.out.println("Mr."+name+" with Jersey Number "+jerseyNo+" is Fielding");
	}
	
	public void batting() {
		System.out.println("Mr."+name+" with Jersey Number "+jerseyNo+" is Batting");
		//DependencyLookup to get cricketbat obj in only batting()
		//get obj
		CricketBat bat = ctx.getBean(beanId,CricketBat.class);//Depencdency Lookup
		//use obj
		int score = bat.scoreRuns();
		System.out.println("Mr."+name+" scored "+score+" runs");
		
	}

	

}
