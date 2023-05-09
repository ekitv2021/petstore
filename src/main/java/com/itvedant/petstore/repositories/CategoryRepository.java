package com.itvedant.petstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore.entities.Category;

@Repository
public interface CategoryRepository 
    extends JpaRepository<Category, Integer>{
    
}
