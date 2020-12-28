package com.vistika.uis.Dao;

import java.util.List;

import com.vastika.uis.util.model.User;

public interface UserDao {

	int saveUserInfo(User user);
	
	int updateUserInfo(User user);
	
	int deleteUserInfo(int id);
	
	List<User>getAllUserInfo();
	
	User getUserById (int id);
}