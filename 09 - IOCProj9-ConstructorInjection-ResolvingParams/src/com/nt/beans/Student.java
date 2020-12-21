package com.nt.beans;

public class Student {
	
	private int sno;
	private String sname;
	private String sadd;
	private float avg;
	
	
	public Student(int sno, String sname, String sadd, float avg) {
		System.out.println("Student::4-Param Constructor");
		this.sno = sno;
		this.sname = sname;
		this.sadd = sadd;
		this.avg = avg;
	}


	public Student(int sno, String sname, String sadd) {
		System.out.println("Student::3-Param Constructor");
		this.sno = sno;
		this.sname = sname;
		this.sadd = sadd;
	}


	public Student(int sno, String sname) {
		System.out.println("Student::2-Param Constructor");
		this.sno = sno;
		this.sname = sname;
	}


	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + ", avg=" + avg + "]";
	}
	
	
	
	
	
	
	
	

}
