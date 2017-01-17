package com.umoo.bonbon.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.umoo.bonbon.aop")
@EnableAspectJAutoProxy
public class AopConfig {
	
}
