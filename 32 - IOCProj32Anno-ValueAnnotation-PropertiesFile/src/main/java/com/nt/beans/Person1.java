package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import lombok.ToString;

@Component("per1")
@ToString
//@PropertySource(value = "com/nt/commons/myFile.properties")//for single properties file
@PropertySource(value = {"com/nt/commons/myFile.properties",
				"com/nt/commons/myFile1.properties"}) //for multiple props file Model 1
/*@PropertySources(value = {@PropertySource(value = "com/nt/commons/myFile.properties"),
		@PropertySource(value = "com/nt/commons/myFile1.properties")})*/ //for multiple props file Model 2
/*@PropertySource(value = "com/nt/commons/myFile.properties")  //for multiple props file Model 3 form java8 repeatation of annotations feature came
@PropertySource(value = "com/nt/commons/myFile1.properties")*/
public class Person1 {
	@Value("${per.id}")//key in properties file
	private int pid;
	@Value("${per.name}")//key in properties file
	private String pname;
	@Value("${per.age}")//key in properties file
	private float age;
	@Value("${os.name}")//system property
	private String os;
	@Value("${Path}")//environment variable
	private String path;

}
