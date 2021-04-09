package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("per")
@ConfigurationProperties(prefix = "info.per")
public class PersonInfo {
	/*@Value("${info.per.id}")
	private int pid;
	@Value("${info.per.name}")
	private String pname;*/
	
	//Simple Properties
	private int id;
	private String name;
	
	//Array,List,Set Properties
	private int marks[];
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	
	//Map,Properties Properties
	private Map<String,Long> idCards;
	private Properties favFruits;
	
	//HAS-A Properties(Composition)
	private Address addr;

}
