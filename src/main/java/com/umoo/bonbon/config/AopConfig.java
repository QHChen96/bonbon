package com.umoo.bonbon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AopConfig {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
}
