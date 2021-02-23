package com.nt.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component("cricketer")
public class Cricketer implements ApplicationContextAware{
	
	@Value("${ckt.name}")
	private String name;
	@Value("${ckt.jerseyNo}")
	private int jerseyNo;
	@Value("${cktbat.id}")
	private String beanId;
	private ApplicationContext ctx;
	
	public Cricketer() {
		System.out.println("Cricketer::0-param constructor");
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
