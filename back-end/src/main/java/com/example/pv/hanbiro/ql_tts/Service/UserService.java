package com.example.pv.hanbiro.ql_tts.service;

import java.util.List;

import com.example.pv.hanbiro.ql_tts.model.User;

public interface UserService {
	List<User> getUsers();
	
	User addUser(User user);
	
	void deleteUser(long id);
	
	void updateUser(long id, User user);
}
