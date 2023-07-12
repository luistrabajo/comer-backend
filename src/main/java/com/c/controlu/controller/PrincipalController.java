package com.c.controlu.controller;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.c.controlu.controller.request.CreateUserDTO;
import com.c.controlu.models.RoleEntity;
import com.c.controlu.models.UserEntity;
import com.c.controlu.models.ERole;
import com.c.controlu.repositories.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;


@RestController
public class PrincipalController {

	
	private static final Logger logger = LoggerFactory.getLogger(PrincipalController.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@Autowired
	private UserRepository userRepository;

	
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World Not Secured";
	}

	@GetMapping("/helloSecured")
	public String helloSecured() {
		return "Hello World Secured";
	}

	
	@PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserDTO createUserDTO){
		
		logger.info("CreateUserDTO: "+createUserDTO.getUsername()+"  "+createUserDTO.getPassword()+"  "+createUserDTO.getRoles()+"  "+createUserDTO.getEmail()+"  ");
		
		
		Set<RoleEntity> roles = createUserDTO.getRoles().stream()
                .map(role -> RoleEntity.builder()
                        .name(ERole.valueOf(role))
                        .build())
                .collect(Collectors.toSet());
		
        UserEntity userEntity = UserEntity.builder()
                .username(createUserDTO.getUsername())
                .password(passwordEncoder.encode(createUserDTO.getPassword()))
                .email(createUserDTO.getEmail())
                .roles(roles)
                .build();

        userRepository.save(userEntity);

        return ResponseEntity.ok(userEntity);
    }



	@DeleteMapping("/deleteUser")
	public String deleteUser(@RequestParam String id) {
		userRepository.deleteById(Long.parseLong(id));
		return "Se ha borrado el user con id".concat(id);
	}


}
