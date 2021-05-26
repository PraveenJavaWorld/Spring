package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean
	public HikariDataSource createDS() {
		HikariDataSource hikari = new HikariDataSource();
		hikari.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikari.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikari.setUsername("system");
		hikari.setPassword("1234");
		hikari.setMaximumPoolSize(30);
		hikari.setMinimumIdle(100);
		hikari.setIdleTimeout(20000);
		return hikari;
	}
	
	@Bean
	public JdbcTemplate createJT() {
		return new JdbcTemplate(createDS());
	}

}
