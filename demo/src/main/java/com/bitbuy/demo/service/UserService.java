package com.bitbuy.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitbuy.demo.entity.User;
import com.bitbuy.demo.model.UserRequest;
import com.bitbuy.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User getUserInfo(long uuId) {
		Optional<User> user = userRepository.findById(uuId);		
		return user.orElseThrow();
	}
	
	@Transactional
	public boolean updateUserInfo(long uuId, UserRequest requestBody) {
		int resultFlag = userRepository.updateUserByUserId(uuId, requestBody.getEmail(), requestBody.getPhone(), requestBody.getName());
		System.out.print("updateUserInfo resultFlag"+resultFlag);
		return true;
	}
}
