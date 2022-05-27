package com.minhldg.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class RegisterForm {
	
	
	@NotBlank(message = "Enter your First Name")
	private String firstName;
	
	@NotBlank(message = "Enter your Last Name")
	private String lastName;
	
	@NotBlank(message = "Enter your email")
	@Email(message = "Enter a valid email address")
	private String email;
	
	@NotBlank(message = "Enter your password")
	@Length(min = 6, message = "Passwords must be at least 6 characters")
	private String password;
	
	@NotBlank(message = "Confirm your password")
	private String confirmPassword;
	
	public RegisterForm() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "UserRegistratrion [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	
	
	
}
