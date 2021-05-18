package com.nt.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("pmAdvice")
@Aspect
@Order(2)
public class PerformanceMonitoringAdvice {
	
	@Around(value = "execution(double com.nt.service.BankService.*(..))")
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
