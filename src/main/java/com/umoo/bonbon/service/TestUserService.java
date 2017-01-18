package com.umoo.bonbon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umoo.bonbon.dao.TestUserDao;
import com.umoo.bonbon.entity.TestUser;
@Service("testUserService")
public class TestUserService {
	@Autowired
	private TestUserDao testUserDao;
	public int saveUser(TestUser user){
		testUserDao.saveUser(user);
		return 1;
	}
	public List<TestUser> getAll(){
		return testUserDao.getUsers();
	}
}
