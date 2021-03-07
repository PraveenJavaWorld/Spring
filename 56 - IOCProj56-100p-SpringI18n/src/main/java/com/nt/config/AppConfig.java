package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration

public class AppConfig {
	
	@Bean("messageSource")
	public ResourceBundleMessageSource createBundle() {
		
		ResourceBundleMessageSource bundle = new ResourceBundleMessageSource();
		bundle.setBasename("com/nt/commons/App");
		return bundle;
		
	}

}
