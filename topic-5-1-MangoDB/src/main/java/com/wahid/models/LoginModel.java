package com.wahid.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginModel {
	
	@NotNull(message = "Username is required") // cannot be blank
	@Size(min = 3, max = 15, message = "the username must be between 3 and 15 characters ")
	@NotEmpty(message = "username can not be blank")
	private String username;
	
	@NotNull(message = "password can not be blank")
	@Size(min = 8, max = 15, message = "Password should be between 8 and 15 characters")
	@NotEmpty(message = "password can not be blank")
	private String password;
	
	
	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	@Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters long")
	private String email;
	
	
	public LoginModel() {
		
	}


	public LoginModel(
			@NotNull(message = "Username is required") @Size(min = 3, max = 15, message = "the username must be between 3 and 15 characters ") @NotEmpty(message = "username can not be blank") String username,
			@NotNull(message = "password can not be blank") @Size(min = 8, max = 15, message = "Password should be between 8 and 15 characters") @NotEmpty(message = "password can not be blank") String password,
			@NotBlank(message = "Email is required") @Email(message = "Invalid email format") @Size(min = 5, max = 50, message = "Email must be between 5 and 50 characters long") String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "LoginModel [username=" + username + ", password=" + password + ", email=" + email + "]";
	}

	
	
	
}
