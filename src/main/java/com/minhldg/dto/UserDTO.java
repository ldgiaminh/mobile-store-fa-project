package com.minhldg.dto;

import java.util.List;

import com.minhldg.model.Role;

import lombok.Data;

@Data
public class UserDTO {

	private Integer id;
	
	private String firstName;

	private String lastName;

	private String email;
	
	private String password;
	
	private List<Role> roles;
}
