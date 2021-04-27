package com.nt.advice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class CachingAdvice {
	
	private Map<String,Object> cacheMap = new HashMap();
	
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

}
