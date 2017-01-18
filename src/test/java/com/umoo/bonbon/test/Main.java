package com.umoo.bonbon.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.umoo.bonbon.test.service.TestService;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		R r = app.getBean(R.class);
		r.outpur();
		TestService testService = app.getBean(TestService.class);
		testService.getHello();
	}
}
