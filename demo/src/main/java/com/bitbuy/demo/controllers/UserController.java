package com.bitbuy.demo.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitbuy.demo.entity.User;
import com.bitbuy.demo.model.UserRequest;
import com.bitbuy.demo.service.UserService;

@RestController
public class UserController {

	public static final String PATH_User = "/api/users/{uuid}";

	@Autowired
	UserService userService;
	
	// Secure end point for user to get their personal information
	@GetMapping(value = PATH_User)
	public User getUserInfo( @PathVariable long uuid) {
		User user = userService.getUserInfo(uuid);
		return user;
	}

	// Secure end point for user to update their personal information
	@PostMapping(value = PATH_User, produces = "application/json")
	public String updateUserInfo(@RequestBody @Valid UserRequest requestBody, @PathVariable long uuid) {
        boolean flag= userService.updateUserInfo(uuid, requestBody);
        
        if (flag)
			return "user updated! ";
		else
			return "Not able to update user Info";

	}

}
