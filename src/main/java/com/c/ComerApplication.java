package com.c;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.c.controlu.models.ERole;
import com.c.controlu.models.RoleEntity;
import com.c.controlu.models.UserEntity;
import com.c.controlu.repositories.UserRepository;
import com.c.controlu.test.TestUser;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200/") 
public class ComerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComerApplication.class, args);
	}
	
	/*
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
	
	*/
	
}
