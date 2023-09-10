package com.io.github.jeanlucasbs.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.io.github.jeanlucasbs.webservice.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
