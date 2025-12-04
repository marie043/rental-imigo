package com.sieun.rentalimigo.login.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sieun.rentalimigo.login.entity.UserRole;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class RegisterDto {
	
	@NotBlank(message = "login id is empty.")
	@JsonProperty("login_id")
	private String loginId;
	
	@NotBlank(message = "password is empty")
	private String password;
	
	@JsonProperty("password_check")
	private String passwordCheck;
	
	@NotBlank(message = "nickname is empty")
	private String nickname;
	
	@NotBlank(message = "regisdent registration number is empty")
	@JsonProperty("resident_registration_number")
	private String residentRegistrationNumber;
	
	private UserRole role; 
	
}
