package com.minhldg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.minhldg.global.GlobalData;
import com.minhldg.model.RegisterForm;
import com.minhldg.model.Role;
import com.minhldg.model.User;
import com.minhldg.repository.RoleRepository;
import com.minhldg.repository.UserRepository;
import com.minhldg.service.CustomerUserDetailService;

@Controller
public class LoginController {
	
	private final CustomerUserDetailService customerUserDetailService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	public LoginController(CustomerUserDetailService customerUserDetailService) {
		this.customerUserDetailService = customerUserDetailService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	
	@GetMapping("/login")
	public String login() {
		GlobalData.cart.clear();
		return "login";
	}
	
	@GetMapping("/register")
	public String registerGet() {
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, 
								HttpServletRequest request) throws ServletException {
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		List<Role> roles = new ArrayList<>();
		roles.add(roleRepository.findById(2).get());
		user.setRoles(roles);
		userRepository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/";
	}
	
//	@GetMapping("/register")
//	public String register(@ModelAttribute RegisterForm registerForm, Model model) {
//		model.addAttribute("registerForm", registerForm);
//		return "register1";
//	}
//	
//	@PostMapping("/register")
//	public String save(@Valid RegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request) throws ServletException{
//		
//		//Check if user exists
//		if(customerUserDetailService.userExists(registerForm.getEmail())) {
//			bindingResult.addError(new FieldError("registerForm", "email", "Email address already in use"));
//		}
//		
//		//Check if the passwords match
//		if(registerForm.getPassword() != null && registerForm.getConfirmPassword() != null) {
//			if(!registerForm.getPassword().equals(registerForm.getConfirmPassword())) {
//				bindingResult.addError(new FieldError("registerForm", "confirmPassword", "Password must match"));
//			}
//		}
//		
//		//Check errors 
//		if(bindingResult.hasErrors()) { 
//			return "register1"; 
//		}		 
//			
//		customerUserDetailService.register(registerForm);
//		return "redirect:/";
//	}
	
}
