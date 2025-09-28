package com.sieun.rentalimigo.login.service;

import org.springframework.stereotype.Service;

import com.sieun.rentalimigo.common.vo.Response;
import com.sieun.rentalimigo.login.dto.RegisterDto;
import com.sieun.rentalimigo.login.entity.User;
import com.sieun.rentalimigo.login.mapper.UserMapper;
import com.sieun.rentalimigo.login.repository.UserRepository;
import com.sieun.rentalimigo.login.vo.RegisterVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final UserMapper userMapper = UserMapper.INSTANCE;

	@Override
	public Response checkLoginIdDupulicated(String loginId) {
		Response<Boolean> res = new Response();
		boolean isDuplicated = userRepository.existsByLoginId(loginId);
		if(isDuplicated) {
			res.setMessage("login id is not valid");
			res.setSuccess(true);
			res.setValue(false);
		}
		else {
			res.setMessage("login id is valid");
			res.setSuccess(true);
			res.setValue(true);
		}
		return res;
	}
	
	@Override
	public Response addUser(RegisterDto register) {
		Response<RegisterVo> res = new Response<RegisterVo>();
		if(!register.getPassword().equals(register.getPasswordCheck())) {
			res.setMessage("password and password check does not match");
			res.setSuccess(false);
			res.setValue(null);
		}
		else {
			if(userRepository.existsByLoginId(register.getLoginId())) {
				res.setMessage("login id is duplicated");
				res.setSuccess(false);
				res.setValue(null);
			}
			else {
				User entity = userMapper.toEntity(register);
				User user = userRepository.save(entity);
				if(user != null) {
					RegisterVo vo = userMapper.toRegisterVo(user);
					res.setMessage("new user is registered");
					res.setSuccess(true);
					res.setValue(vo);
				}
				else {
					res.setMessage("failed to register new user");
					res.setSuccess(false);
					res.setValue(null);
				}
			}
		}
		return res;
	}
	
	
}
