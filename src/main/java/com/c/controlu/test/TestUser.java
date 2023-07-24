package com.c.controlu.test;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.c.controlu.models.ERole;
import com.c.controlu.models.RoleEntity;
import com.c.controlu.models.UserEntity;
import com.c.controlu.repositories.UserRepository;

public class TestUser {
	
	
	public TestUser() {
		
	}
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Bean
	CommandLineRunner init(){
		return args -> {
			UserEntity userEntity = UserEntity.builder()
					.email("luis@mail.com")
					.username("Luis")
					.password(passwordEncoder.encode("Password1*"))
					.roles(Set.of(RoleEntity.builder()
							.name(ERole.valueOf(ERole.ADMIN.name()))
							.build()))
					.build();

			userRepository.save(userEntity);
			
		};
	}
	
	

}
