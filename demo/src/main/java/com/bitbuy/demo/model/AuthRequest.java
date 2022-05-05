package com.bitbuy.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class AuthRequest {

	// adding some validations
	@NotNull(message = "REQUIRED")
	private String username;

	// adding some validations
	/* regex pattern for valid password
	 * 4 to 8 character password requiring numbers and both lowercase and uppercase letters
	 */
	@NotNull(message = "REQUIRED")
	@Size(min = 2, max = 30)
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,15}$" , message= "Invalid password" )
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
