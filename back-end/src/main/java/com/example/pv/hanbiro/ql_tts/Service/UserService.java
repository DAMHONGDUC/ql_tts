package com.example.pv.hanbiro.ql_tts.Service;

import java.util.List;

import com.example.pv.hanbiro.ql_tts.Model.User;

public interface UserService {
	List<User> getUsers();
	
	User addUser(User user);
	
	boolean deleteUser(int id);
}
