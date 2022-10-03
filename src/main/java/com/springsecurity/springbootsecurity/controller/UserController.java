package com.springsecurity.springbootsecurity.controller;

import com.springsecurity.springbootsecurity.model.User;
import com.springsecurity.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/hello")
	public String helloUser(){
		return "Hello User";
	}

	@GetMapping("/users")
	public List<User> getUsers(){

		return  userService.getUser();
	}



}
