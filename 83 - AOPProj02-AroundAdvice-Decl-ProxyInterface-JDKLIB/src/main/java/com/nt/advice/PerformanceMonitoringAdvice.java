package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceMonitoringAdvice {
	
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
