package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.nt.exception.InternalProblemException;

@Component("cegl")
@Aspect
public class CommonExceptionGrapher_Logger {
	
	@AfterThrowing(value = "execution(double com.nt.service.ShoppingStore.calsBillAmount(..))",throwing = "iae")
	public void exceptionLogger(JoinPoint jp,IllegalArgumentException iae) throws Throwable {
		//common exception logging
		Writer writer = new FileWriter("F:/Java/ExceptionLogger.txt",true);
		writer.write(jp.getSignature()+ " with args "+Arrays.toString(jp.getArgs())+ " has raised "+iae+"\n");
		writer.flush();
		writer.close();
		
		//Exception Translation/Graphing
		throw new InternalProblemException(jp.getSignature()+ " with args "+Arrays.toString(jp.getArgs())+ " has raised "+iae+"\n");
	}

}
