package com.umoo.bonbon.service;

import org.springframework.stereotype.Service;

import com.umoo.bonbon.dao.TestUserDao;
import com.umoo.bonbon.entity.TestUser;

@Service
public class TestService {
	private TestUserDao testUserDao;
	public int saveUser(TestUser user){
		testUserDao.saveUser(user);
		return 1;
	}
}
