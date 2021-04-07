package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name = "hikari")
	public DataSource createDS() {
		HikariDataSource hikari = new HikariDataSource();
		hikari.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikari.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikari.setUsername("system");
		hikari.setPassword("1234");
		hikari.setIdleTimeout(3000);
		hikari.setMaximumPoolSize(10);
		hikari.setMinimumIdle(5);
		hikari.setConnectionTimeout(60000);
		return hikari;
	}
	
	@Bean(name = "jt")
	public JdbcTemplate createJT() {
		return new JdbcTemplate(createDS());
	}

}
