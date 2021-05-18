package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("advice")
@Aspect
public class AroundCaching_PerformanceMonitoringAdvice {
	
	private Map<String,Object> cacheMap = new HashMap<>();
	
	@Pointcut(value = "execution(double com.nt.service.BankService.*(..))")
	public void myPtc() {
		
	}
	@Around(value = "myPtc()")
	@Order(10)
	public Object caching(ProceedingJoinPoint pjp) throws Throwable{
		//prepare key
		String key = pjp.getSignature()+Arrays.toString(pjp.getArgs());
		Object retVal = null;
		//checks in cache
		if(!cacheMap.containsKey(key)) {
			retVal = pjp.proceed();//invoke the b.method of target class
			cacheMap.put(key, retVal);//insert results into cache
			System.out.println("From Target Class");
		}
		else {
			retVal = cacheMap.get(key);//gather results from cache
			System.out.println("From Cache");
		}
		return retVal;
	}
	
	@Around(value = "myPtc()")
	@Order(20)
	public Object performance(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("PerformanceMonitoringAdvice.performance()--Before Entering");
		long start = System.currentTimeMillis();
		Object retVal = pjp.proceed();//calls target method
		long end = System.currentTimeMillis();
		System.out.println("PerformanceMonitoringAdvice.performance()--After Exiting");
		System.out.println(pjp.getSignature()+" with args "+Arrays.toString(pjp.getArgs())+" has taken "+(end-start)+" milli seconds");
		return retVal;
	}

}
