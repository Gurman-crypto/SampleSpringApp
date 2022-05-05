package com.bitbuy.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitbuy.demo.entity.User;
import com.bitbuy.demo.model.AuthRequest;
import com.bitbuy.demo.repository.UserRepository;

@Service
public class AuthService {

	/*
	 * //remaining tasks: 2 may,2022 :after 3 pm 1.end to end from controller to
	 * repo inserts and check in H2 db 2. add secure HTTPS endpoints
	 */
	@Autowired
	UserRepository userRepository;

	@Transactional
	public boolean createAccount(AuthRequest requestBody) {

		User user = new User();
		
		user.setUsername(requestBody.getUsername());
		user.setPassword(requestBody.getPassword());
		
		userRepository.save(user);
		return true;
	}

	public boolean logIn(AuthRequest requestBody) {

		String password = userRepository.findPasswordByUserName(requestBody.getUsername());

		if (requestBody.getPassword().equals(password))
			return true;
		else
			return false;
	}
}
