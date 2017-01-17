package com.umoo.bonbon.web;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	public String index() {
		return "index";
	}
}
