package com.umoo.bonbon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 
 * @author umoo
 * 扫描除了SpringMVC的配置的bean
 */
@Configuration
@ComponentScan(basePackages = {"com.umoo.bonbon"},
	excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableAspectJAutoProxy.class)})
public class RootConfig {}
