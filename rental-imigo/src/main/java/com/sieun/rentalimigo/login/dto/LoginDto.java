package com.sieun.rentalimigo.login.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginDto {
	
	@NotBlank(message = "login id is empty")
	private String loginId;
	
	@NotBlank(message = "password is empty")
	private String password;
	
}
