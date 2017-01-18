package com.umoo.bonbon.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.umoo.bonbon.entity.TestUser;

public interface TestUserDao {
	
	public void saveUser(TestUser testUser);
	
	@Select("SELECT * FROM test_user")
	public List<TestUser> getUsers();
}
