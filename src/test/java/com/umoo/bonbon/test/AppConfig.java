package com.umoo.bonbon.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages={"com.umoo.bonbon.test"})
@EnableAspectJAutoProxy
public class AppConfig {
	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
		PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
		placeholderConfigurer.setFileEncoding("UTF-8");
		placeholderConfigurer.setLocations(new ClassPathResource("jdbc.properties"));
		return placeholderConfigurer;
	}
}
