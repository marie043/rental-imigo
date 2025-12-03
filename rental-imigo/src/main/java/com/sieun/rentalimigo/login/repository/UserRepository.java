package com.sieun.rentalimigo.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sieun.rentalimigo.login.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByLoginId(String loginId);
	boolean existsByResidentRegistrationNumber(String residentRegistrationNumber);
	
}
