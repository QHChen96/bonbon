package com.umoo.bonbon.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.umoo.bonbon.test")
@PropertySource("classpath:jdbc.properties")
public class AppConfig {
	
}
