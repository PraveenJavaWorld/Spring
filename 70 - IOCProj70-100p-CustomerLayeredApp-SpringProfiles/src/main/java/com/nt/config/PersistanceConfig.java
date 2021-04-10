package com.nt.config;

import java.beans.PropertyVetoException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistanceConfig {
	
	@Bean("bds")
	@Profile("dev")
	public BasicDataSource createApacheDBCP2DS() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		bds.setUrl("jdbc:mysql:///ntsp613");
		bds.setUsername("root");
		bds.setPassword("1234");
		return bds;
	}
	
	@Bean("ds")
	@Profile("test")
	public DataSource createTomcatCPDS() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql:///ntsp613");
		ds.setUsername("root");
		ds.setPassword("1234");
		return ds;
	}
	
	@Bean("cpds")
	@Profile("uat")
	public ComboPooledDataSource createC3P0DS() throws PropertyVetoException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cpds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cpds.setUser("system");
		cpds.setPassword("1234");
		return cpds;
	}
	
	@Bean("hikari")
	@Profile("prod")
	public HikariDataSource createHikariCPDS() {
		HikariDataSource hikari = new HikariDataSource();
		hikari.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hikari.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikari.setUsername("system");
		hikari.setPassword("1234");
		return hikari;
	}

}
