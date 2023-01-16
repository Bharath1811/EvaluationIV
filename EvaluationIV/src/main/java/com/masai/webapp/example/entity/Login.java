package com.masai.webapp.example.entity;

import jakarta.validation.constraints.Pattern;

public class Login {
	@Pattern(regexp = "^[a-zA-Z]+$")
	String firstname;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{6,12}$).*$")
	String password;
	
	public Login() {}

	public Login(@Pattern(regexp = "^[a-zA-Z]+$") String firstname,
			@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{6,12}$).*$") String password) {
		super();
		this.firstname = firstname;
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
