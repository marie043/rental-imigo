package com.sieun.rentalimigo.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sieun.rentalimigo.common.vo.Response;
import com.sieun.rentalimigo.login.dto.RegisterDto;
import com.sieun.rentalimigo.login.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/signin/{login-id}")
	public Response getLoginIdValid(@PathVariable("login-id")String loginId){
		return userService.checkLoginIdDupulicated(loginId);
	}
	
	@PostMapping("/signin")
	public Response createUser(@RequestBody RegisterDto register) {
		return userService.addUser(register);
	}
}
