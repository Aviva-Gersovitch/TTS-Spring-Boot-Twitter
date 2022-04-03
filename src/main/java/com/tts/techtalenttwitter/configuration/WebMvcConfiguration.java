package com.tts.techtalenttwitter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{

	//Write the instructions to how to create a BCryptPasswordEncoder
	//We put a method inside a class with @Configuration annotation
	//And annotate it with @Bean - object whose lifecycle is managed by spring boot - created when asked for and deleted when no longer needed
	
	@Bean
	//Method must return type you are defining how to create
	public BCryptPasswordEncoder passwordEncoder() {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		return bCryptPasswordEncoder;
	}
	
}
