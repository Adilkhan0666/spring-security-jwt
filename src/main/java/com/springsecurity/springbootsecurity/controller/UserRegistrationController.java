package com.springsecurity.springbootsecurity.controller;

import com.springsecurity.springbootsecurity.entity.UserRegistrationEntity;
import com.springsecurity.springbootsecurity.model.User;
import com.springsecurity.springbootsecurity.service.UserRegistrationService;
import com.springsecurity.springbootsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRegistrationController {

	@Autowired
	private UserRegistrationService userRegistrationService;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User user){
		return new ResponseEntity<>(userRegistrationService.registerUser(user), HttpStatus.OK);
	}
}
