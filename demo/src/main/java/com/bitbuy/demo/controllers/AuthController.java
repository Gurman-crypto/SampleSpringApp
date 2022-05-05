package com.bitbuy.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitbuy.demo.model.AuthRequest;
import com.bitbuy.demo.service.AuthService;

@RestController
public class AuthController {

	public static final String PATH_Register = "/api/register";
	public static final String PATH_LogIn = "/api/login";

	@Autowired
	AuthService authService;

	// End point for user to 'create' an account
	@PostMapping(value = PATH_Register, produces = "application/json")
	public String register(@Validated @RequestBody AuthRequest requestBody) {

		boolean flag = authService.createAccount(requestBody);

		if (flag)
			return "account created! ";
		else
			return "Not able to create account";
	}

	// End point for user to log in
	@PostMapping(value = PATH_LogIn, produces = "application/json")
	public String logIn(@Validated @RequestBody AuthRequest requestBody) {
		boolean flag = authService.logIn(requestBody);

		if (flag)
			return "succesfull login ";
		else
			return "login failure";

	}

}
