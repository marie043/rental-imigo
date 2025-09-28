package com.sieun.rentalimigo.login.service;

import com.sieun.rentalimigo.common.vo.Response;
import com.sieun.rentalimigo.login.dto.RegisterDto;

public interface UserService {

	Response checkLoginIdDupulicated(String loginId);

	Response addUser(RegisterDto register);

}
