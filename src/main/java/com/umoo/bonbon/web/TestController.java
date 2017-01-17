package com.umoo.bonbon.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.umoo.bonbon.dto.BaseResult;
import com.umoo.bonbon.entity.TestUser;
import com.umoo.bonbon.service.TestService;
@RestController
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TestService testService;
	@RequestMapping("/testlogin")
	public BaseResult<TestUser> login(@Validated TestUser user, BindingResult bindingResult) {
		logger.info("登录>>>");
		if(bindingResult.hasErrors()){
			String message = "";
			for(FieldError error : bindingResult.getFieldErrors()){
				message += error.getDefaultMessage();
			}
			return new BaseResult<>(false, message);
		}
		return new BaseResult<>(true, user);
	}
	@RequestMapping("/gethello")
	public String getHello(){
		return testService.getHello();
	}
}
