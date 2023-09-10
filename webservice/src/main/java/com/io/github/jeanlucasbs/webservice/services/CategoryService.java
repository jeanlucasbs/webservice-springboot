package com.io.github.jeanlucasbs.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.github.jeanlucasbs.webservice.entities.Category;
import com.io.github.jeanlucasbs.webservice.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long ID) {
		Optional<Category> obj = repository.findById(ID);
		return obj.get();
	}
}
