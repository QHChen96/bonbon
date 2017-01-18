package com.umoo.bonbon.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class R {
	@Value("${jdbc.username}")
	private String username;
	public void outpur(){
		System.out.println(username);
	}
}
