package com.io.github.jeanlucasbs.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.io.github.jeanlucasbs.webservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
