package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Users;
import com.example.demo.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("/register")
public String addUser(@ModelAttribute Users user) {
		boolean userStatus=service.emailExists(user.getEmail());
	if(userStatus ==false) {
		service.addUser(user);
		System.out.println("user added");
	}else {
		System.out.println("user already exists");
	}
		return "home";
	
}
	@PostMapping("validate")
	public String validate(@RequestParam("email")String email,
		@RequestParam("password")String password,
		HttpSession session) {
		if(service.validateUser(email,password)==true) {
			String role=service.getRole(email);
			session.setAttribute("email", email);
			if(role.equals("admin")) {
				return "adminHome";
			}else {
			return "coustomerHome";
		}
		}
		else {
			return "login";
		}
	}
	

		@GetMapping("logout")
		public String logout(HttpSession session) {
			return "login";
		}
}









