package com.umoo.bonbon.web;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.umoo.bonbon.dto.BaseResult;
import com.umoo.bonbon.entity.TestUser;
import com.umoo.bonbon.service.TestUserService;
@RestController
public class TestController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TestUserService testUserService;
	
	@RequestMapping(value = "/testuser", method = RequestMethod.POST)
	public BaseResult<Integer> saveUser(TestUser user){
		logger.info(user.toString());
		BaseResult<Integer> result = new BaseResult<Integer>(true, testUserService.saveUser(user));
		return result;
	}
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<TestUser> getUsers(){
		return testUserService.getAll();
	}
}
