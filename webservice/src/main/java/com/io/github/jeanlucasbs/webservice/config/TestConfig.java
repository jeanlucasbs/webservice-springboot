package com.io.github.jeanlucasbs.webservice.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.io.github.jeanlucasbs.webservice.entities.User;
import com.io.github.jeanlucasbs.webservice.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Jean", "jean@gmail.com", "99999999", "123456");
		User u2 = new User(null, "Maria", "maria@gmail.com", "11111111", "654123");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}

}
