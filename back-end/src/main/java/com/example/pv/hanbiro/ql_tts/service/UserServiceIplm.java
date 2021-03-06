package com.example.pv.hanbiro.ql_tts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.pv.hanbiro.ql_tts.exception.InvalidUserException;
import com.example.pv.hanbiro.ql_tts.model.User;
import com.example.pv.hanbiro.ql_tts.repository.UserRepository;

@Service
public class UserServiceIplm implements UserService{
	private UserRepository repository;

	public UserServiceIplm(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}

	@Override
	public User addUser(User user) {
		return repository.save(user);
	}

	@Override
	public void deleteUser(long id) {		
		Optional<User> userOpt = repository.findById(id);
		if(!userOpt.isPresent()) {
			throw new InvalidUserException("User ID is not existed.");
		}
		repository.delete(userOpt.get());
		
	}

	@Override
	public void updateUser(long id, User user) {
		
		if(repository.findById(id).isPresent()) {
			User Userupdate = repository.findById(id).get();
			
			Userupdate.setTendangnhap(user.getTendangnhap());
			Userupdate.setMatkhau(user.getMatkhau());
			Userupdate.setEmail(user.getEmail());
			Userupdate.setSdt(user.getSdt());
			Userupdate.setTen(user.getTen());
			
			repository.save(Userupdate);
			
		}	
		else 
		{		
			throw new InvalidUserException("User ID is not existed.");
		}	
	}

	
	
	
		
}
