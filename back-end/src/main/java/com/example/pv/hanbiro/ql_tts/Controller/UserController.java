package com.example.pv.hanbiro.ql_tts.Controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pv.hanbiro.ql_tts.Model.User;
import com.example.pv.hanbiro.ql_tts.Service.UserService;

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
	
	@PostMapping
	public ResponseEntity<User> createNewStudent(@RequestBody User student){
		User newStudent = service.addUser(student);
		
		if(newStudent == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") String mssv){
		boolean result = service.deleteUser(mssv.toUpperCase());
		
		if(result)
			return new ResponseEntity<String>("Đã xóa thành công.", HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>("ID không tồn tại", HttpStatus.BAD_REQUEST);
	}
	
}
