package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component("per")
@ToString
public class Person {
	@Value("123")
	private int pid;
	@Value("Praveen")
	private String pname;
	@Value("23")
	private float age;

}
