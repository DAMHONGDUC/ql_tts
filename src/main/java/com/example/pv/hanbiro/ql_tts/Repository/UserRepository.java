package com.example.pv.hanbiro.ql_tts.Repository;

import java.util.List;

import com.example.pv.hanbiro.ql_tts.Model.User;

public interface UserRepository {
	List<User> getUser();
	
	User addUser(User user);
	
	boolean deleteUser(String id);
}
