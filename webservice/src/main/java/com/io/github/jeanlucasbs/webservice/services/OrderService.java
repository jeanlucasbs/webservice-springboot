package com.io.github.jeanlucasbs.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.io.github.jeanlucasbs.webservice.entities.Order;
import com.io.github.jeanlucasbs.webservice.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long ID) {
		Optional<Order> obj = repository.findById(ID);
		return obj.get();
	}
}
