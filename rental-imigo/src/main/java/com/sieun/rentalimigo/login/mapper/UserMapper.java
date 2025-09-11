package com.sieun.rentalimigo.login.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.sieun.rentalimigo.login.dto.RegisterDto;
import com.sieun.rentalimigo.login.entity.User;
import com.sieun.rentalimigo.login.vo.RegisterVo;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper{
	
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User toEntity(RegisterDto dto);
	
	RegisterVo toRegisterVo(User entity);

}
