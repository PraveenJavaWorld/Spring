package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.nt.external.IICCScoreComp;
import com.nt.locator.ICCScoreCompServiceLocator;

@Configuration
@ComponentScan(basePackages = "com.nt")
public class AppConfig {
	
	@Bean("iccLocater")
	public IICCScoreComp createExtComp() {
		
		return ICCScoreCompServiceLocator.getInstance();
	}

}
