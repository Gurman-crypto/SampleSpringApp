package com.bitbuy.demo.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Valid
public class UserRequest {

	// adding some validations
	@NotNull(message = "REQUIRED")
	@Size(min=2)
	private String name;

	/*
	 * regex pattern for valid email
	 * validated expression in https://regexr.com
	 */
	@NotNull(message = "REQUIRED")
	@Pattern(regexp = "^(?:[a-zA-Z0-9]+)@(?:[a-zA-Z0-9]+)+(?:\\.[a-zA-Z]*){1,2}$" , message ="Invalid email")
	private String email;

	// adding some validations : pattern allowed : (+1)123-456-7890
	@NotNull(message = "REQUIRED")
	@Pattern(regexp = "^\\(\\+\\d\\)\\d{3}-\\d{3}-\\d{4}$" , message ="Invalid Phone No")	
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
