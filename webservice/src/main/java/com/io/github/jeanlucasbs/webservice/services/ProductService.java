package com.io.github.jeanlucasbs.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.github.jeanlucasbs.webservice.entities.Product;
import com.io.github.jeanlucasbs.webservice.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long ID) {
		Optional<Product> obj = repository.findById(ID);
		return obj.get();
	}
}
