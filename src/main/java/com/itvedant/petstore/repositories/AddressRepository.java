package com.itvedant.petstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore.entities.Address;

@Repository
public interface AddressRepository 
    extends  JpaRepository<Address, Integer>{
    
}
