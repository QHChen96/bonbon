package com.umoo.bonbon.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class MySqlConfig {
	@Value("jdbc.username")
	private String username;
	
	@Value("jdbc.password")
	private String password;
	
	@Value("jdbc.driverClassName")
	private String driverClassName;
	
	
	@Bean
	public DataSource dataSource(){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		return dataSource;
	}
	
}
