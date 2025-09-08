package com.sieun.rentalimigo.login.service;

import org.springframework.stereotype.Service;

import com.sieun.rentalimigo.common.vo.Response;
import com.sieun.rentalimigo.login.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public Response<Boolean> checkLoginIdDupulicated(String loginId) {
		Response<Boolean> res = new Response();
		boolean isDuplicated = userRepository.existsByLoginId(loginId);
		if(isDuplicated) {
			res.setMessage("login id is not valid");
			res.setValue(false);
		}
		else {
			res.setMessage("login id is valid");
			res.setValue(true);
		}
		return res;
	}
	
	
}
