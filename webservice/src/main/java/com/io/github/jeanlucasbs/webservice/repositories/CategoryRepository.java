package com.io.github.jeanlucasbs.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.io.github.jeanlucasbs.webservice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
