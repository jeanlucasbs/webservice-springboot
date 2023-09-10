package com.io.github.jeanlucasbs.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.github.jeanlucasbs.webservice.entities.User;
import com.io.github.jeanlucasbs.webservice.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long ID) {
		Optional<User> obj = repository.findById(ID);
		return obj.get();
	}
}
