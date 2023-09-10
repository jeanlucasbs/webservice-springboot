package com.io.github.jeanlucasbs.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.io.github.jeanlucasbs.webservice.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
