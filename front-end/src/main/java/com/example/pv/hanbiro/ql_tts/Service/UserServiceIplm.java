package com.example.pv.hanbiro.ql_tts.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pv.hanbiro.ql_tts.Model.User;
import com.example.pv.hanbiro.ql_tts.Repository.UserRepository;

@Service
public class UserServiceIplm implements UserService{
	private UserRepository repository;

	public UserServiceIplm(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<User> getUsers() {
		return repository.getUsers();
	}

	@Override
	public User addUser(User user) {
		return repository.addUser(user);
	}

	@Override
	public boolean deleteUser(String id) {
		return repository.deleteUser(id);
	}

		
}
