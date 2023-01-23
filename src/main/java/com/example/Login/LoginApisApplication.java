package com.example.Login;

import com.example.Login.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LoginApisApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginApisApplication.class, args);
	}
	@Bean
	public  PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
