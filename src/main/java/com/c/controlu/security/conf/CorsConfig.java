package com.c.controlu.security.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		
		return new WebMvcConfigurer() {
		
			public void addCorsMappings(CorsRegistry registri) {
				registri.addMapping("/**")
				.allowedOrigins("http://localhost:4200")
				.allowedMethods("*");
			}
		};
		
	}
}
