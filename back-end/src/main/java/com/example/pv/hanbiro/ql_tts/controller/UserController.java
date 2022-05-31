package com.example.pv.hanbiro.ql_tts.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pv.hanbiro.ql_tts.model.User;
import com.example.pv.hanbiro.ql_tts.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	@GetMapping("users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> students = service.getUsers();
		
		return new ResponseEntity<>(students, HttpStatus.OK);
	}
		
	
	@PostMapping("create")
	public ResponseEntity<User> createNewStudent(@RequestBody User student){
		User newStudent = service.addUser(student);
		
		if(newStudent == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
		
		service.deleteUser(id);
		return new ResponseEntity<> ("Deleted user successfully", HttpStatus.OK);
	}
	
	@PutMapping("update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id, @RequestBody User user) {
		service.updateUser(id, user);
		return new ResponseEntity<> ("Update user successfully", HttpStatus.OK);
	}
	
}
