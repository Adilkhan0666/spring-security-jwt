package com.springsecurity.springbootsecurity.controller;

import com.springsecurity.springbootsecurity.model.JwtTokenRequest;
import com.springsecurity.springbootsecurity.model.JwtTokenResponse;
import com.springsecurity.springbootsecurity.model.User;
import com.springsecurity.springbootsecurity.service.CustomUserDetailsService;
import com.springsecurity.springbootsecurity.service.UserService;
import com.springsecurity.springbootsecurity.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JWTController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;


	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtTokenRequest request) throws Exception {


		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
		}catch (UsernameNotFoundException e){
			e.printStackTrace();
			throw new Exception("User not found");
		}catch (BadCredentialsException e){
			e.printStackTrace();
			throw new Exception("Bad Credentials");

		}

		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(request.getUsername());

		String token = jwtTokenUtil.generateToken(userDetails);

		System.out.println("token "+token);

		return ResponseEntity.ok(new JwtTokenResponse(token));
	}



}
