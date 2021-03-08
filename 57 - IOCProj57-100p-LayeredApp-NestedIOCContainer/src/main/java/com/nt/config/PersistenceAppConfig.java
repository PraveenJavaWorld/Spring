package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource(value = "com/nt/commons/jdbc.properties")
public class PersistenceAppConfig {
	
	/*@Bean("hikari")
	public HikariDataSource createSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		ds.setUsername("system");
		ds.setPassword("1234");
		ds.setMaximumPoolSize(100);
		ds.setMinimumIdle(10);
		ds.setIdleTimeout(1000);
		return ds;
	}*/
	
	@Autowired
	private Environment env;
	
	@Bean("hikari")
	public HikariDataSource createSource() {
		HikariDataSource ds = new HikariDataSource();
		ds.setDriverClassName(env.getRequiredProperty("ds.driver"));
		ds.setJdbcUrl(env.getRequiredProperty("ds.url"));
		ds.setUsername(env.getRequiredProperty("ds.username"));
		ds.setPassword(env.getRequiredProperty("ds.password"));
		ds.setMaximumPoolSize(Integer.parseInt(env.getRequiredProperty("ds.maxpool")));
		ds.setMinimumIdle(Integer.parseInt(env.getRequiredProperty("ds.minIdle")));
		ds.setIdleTimeout(Integer.parseInt(env.getRequiredProperty("ds.idleTimeOut")));
		return ds;
	}

}
