package com.umoo.bonbon.config;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@PropertySource(value={"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
@MapperScan(basePackages="com.umoo.bonbon.dao")
public class MybatisConfig {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.driver}")
	private String driverClassName;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${filters}")
	private String filters;
	
	@Value("${maxActive}")
	private Integer maxActive;
	
	@Value("${initialSize}")
	private Integer initialSize;
	
	@Value("${maxWait}")
	private Long maxWait;
	
	@Value("${minIdle}")
	private Integer minIdle;
	
	@Value("${maxIdle}")
	private Integer maxIdle;
	
	@Value("${timeBetweenEvictionRunsMillis}")
	private Integer timeBetweenEvictionRunsMillis;
	
	@Value("${minEvictableIdleTimeMillis}")
	private Integer minEvictableIdleTimeMillis;
	
	@Value("${validationQuery}")
	private String validationQuery;
	
	@Value("${testWhileIdle}")
	private boolean testWhileIdle;
	
	@Value("${testOnBorrow}")
	private boolean testOnBorrow;
	
	@Value("${testOnReturn}")
	private boolean testOnReturn;
	
	@Value("${maxOpenPreparedStatements}")
	private Integer maxOpenPreparedStatements;
	
	@Value("${removeAbandoned}")
	private boolean removeAbandoned;
	
	@Value("${removeAbandonedTimeout}")
	private Integer removeAbandonedTimeout;
	
	@Value("${logAbandoned}")
	private boolean logAbandoned;
	@Bean("dataSource")
	public DataSource dataSource() throws Exception{
		LOGGER.info("dataSource>>>" + username);
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setFilters(filters);
		dataSource.setMaxActive(maxActive);
		dataSource.setInitialSize(initialSize);
		dataSource.setMaxWait(maxWait);
		dataSource.setMinIdle(minIdle);
		dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		dataSource.setValidationQuery(validationQuery);
		dataSource.setTestWhileIdle(testWhileIdle);
		dataSource.setTestOnBorrow(testOnBorrow);
		dataSource.setTestOnReturn(testOnReturn);
		dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
		dataSource.setRemoveAbandoned(removeAbandoned);
		dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
		dataSource.setLogAbandoned(logAbandoned);
		return dataSource;
	}
	@Bean("sqlSessionFactory")
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
		sqlSessionFactory.setTypeAliasesPackage("com.umoo.bonbon.entity");
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml"));
		return sqlSessionFactory;
	}
}
