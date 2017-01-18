package com.umoo.bonbon.test;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopTest {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	@Pointcut("execution(* com.umoo.bonbon.test.service.*.*(..))")
	public void services(){}
	@Around("services()")
	public Object arround(ProceedingJoinPoint joinPoint) throws Throwable{
		LOGGER.info("before service");
		Object object = joinPoint.proceed();
		LOGGER.info("after service");
		return object;
	}
}
