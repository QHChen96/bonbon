package com.umoo.bonbon.test;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.umoo.bonbon.config.WebMvcConfig;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);
		R r = app.getBean(R.class);
		r.outpur();
	}
}
