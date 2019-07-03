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
//	ユーザー登録
	public boolean createUser(User user) {
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		try {
			User result = userRepository.findByUserId(user.getUserId());
			if(result == null) {
				userRepository.saveAndFlush(user);
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}

	public User getUserByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}
//	プロフィール登録
	public User createProfile(User user, User viewer) {
		viewer.setArea(user.getArea());
		viewer.setBornYear(user.getBornYear());
		viewer.setGender(user.getGender());
		return userRepository.saveAndFlush(viewer);
	}
}