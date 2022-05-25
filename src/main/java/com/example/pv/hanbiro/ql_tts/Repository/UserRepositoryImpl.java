package com.example.pv.hanbiro.ql_tts.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.pv.hanbiro.ql_tts.Model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private List<User> users;
	
	UserRepositoryImpl()
	{
		users = new ArrayList<>();
		users.add(new User("id1", "tendangnhap1", "matkhau1", "ten1", "email1", "sdt1" ));
		users.add(new User("id2", "tendangnhap2", "matkhau2", "ten2", "email2", "sdt2" ));
		users.add(new User("id3", "tendangnhap3", "matkhau3", "ten3", "email3", "sdt3" ));
		users.add(new User("id4", "tendangnhap4", "matkhau4", "ten4", "email4", "sdt4" ));
	}
	
	@Override
	public List<User> getUsers() {		
		return users;
	}

	@Override
	public User addUser(User user) {
		if(user == null)
			return null;
		
		users.add(user);
		return user;	
	}

	@Override
	public boolean deleteUser(String id) {
		if("".equals(id))
			return false;
		
		for(User user : users)
			if(user.getId().equals(user)) {
				users.remove(user);
				return true;
			}
		
		return false;		
	}
}
