package com.sieun.rentalimigo.login.dto;

import com.sieun.rentalimigo.login.entity.User;
import com.sieun.rentalimigo.login.entity.UserRole;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class RegisterDto {
	
	@NotBlank(message = "login id is empty.")
	private String loginId;
	
	@NotBlank(message = "password is empty")
	private String password;
	
	private String passwordCheck;
	
	@NotBlank(message = "nickname is empty")
	private String nickname;
	
	public User toEntity() {
		return User.builder()
				.loginId(this.loginId)
				.password(this.password)
				.nickname(this.nickname)
				.role(UserRole.USER)
				.build();
	}
	public User toEntity(String encodedPassword) {
		return User.builder()
				.loginId(this.loginId)
				.password(encodedPassword)
				.nickname(this.nickname)
				.role(UserRole.USER)
				.build();
	}
	
}
