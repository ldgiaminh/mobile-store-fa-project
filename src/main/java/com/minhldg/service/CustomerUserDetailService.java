package com.minhldg.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.minhldg.model.CustomerUserDetail;
import com.minhldg.model.RegisterForm;
import com.minhldg.model.User;
import com.minhldg.repository.UserRepository;

@Service
public class CustomerUserDetailService implements UserDetailsService {
		
	
	@Autowired
	UserRepository userRepository;
	
//	@Autowired
//	ModelMapper modelMapper;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findUserByEmail(email);
		user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return user.map(CustomerUserDetail::new).get();		
	}
	
	public User save(User entity) {
		return userRepository.save(entity);
	}
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
			
	public void removeUserById(int id) {
		userRepository.deleteById(id);
	}
	
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}
	
	public Optional<User> findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	
	public boolean userExists(String email) {
		return findUserByEmail(email).isPresent();
	}
	
//	public User register(RegisterForm registerForm) {
//		User user = new User();
//		//Map Register to User
//		modelMapper.map(registerForm, user);
//		return save(user);
//	}
		
}
