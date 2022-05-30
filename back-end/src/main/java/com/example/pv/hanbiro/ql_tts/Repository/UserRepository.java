package com.example.pv.hanbiro.ql_tts.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pv.hanbiro.ql_tts.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
