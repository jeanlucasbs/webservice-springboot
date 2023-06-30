package com.io.github.jeanlucasbs.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.io.github.jeanlucasbs.webservice.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
