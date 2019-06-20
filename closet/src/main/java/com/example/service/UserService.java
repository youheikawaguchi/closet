package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.User;
import com.example.repository.UserRepository;
@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public User createUser(User user) {
//		String encodedPassword = passwordEncoder.encode(rawPassword);
//		user.setPassword(encodedPassword);
		
//		user.setUserId(user.userId);
//		user.setPassword(password);
		
		return userRepository.saveAndFlush(user);
	}
	
}
