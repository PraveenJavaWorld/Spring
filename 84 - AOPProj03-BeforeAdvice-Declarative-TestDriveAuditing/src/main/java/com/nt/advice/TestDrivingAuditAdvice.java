package com.nt.advice;

import java.io.FileWriter;
import java.io.Writer;
import java.util.Date;

public class TestDrivingAuditAdvice {
	
	/*public void testDriving(JoinPoint jp) throws Throwable{
		Object args[] = jp.getArgs();
		String auditLogMsg = args[0]+ " customer had to came to TestDrive the car "+args[1] + " on " + new Date();
		Writer writer = new FileWriter("F:/Java/EmpLog.txt", true);
		writer.write(auditLogMsg+"\n");
		writer.flush();
		writer.close();
	}*/
	
	public void testDriving(String custName,String carModel,double price) throws Throwable{
		String auditLogMsg = custName+ " customer had to came to TestDrive the car "+carModel + " on " + new Date();
		Writer writer = new FileWriter("F:/Java/EmpLog.txt", true);
		writer.write(auditLogMsg+"\n");
		writer.flush();
		writer.close();
	}

}
