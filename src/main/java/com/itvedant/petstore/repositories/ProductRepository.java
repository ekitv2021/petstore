package com.itvedant.petstore.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.itvedant.petstore.entities.Product;

//@CrossOrigin(origins = "http://localhost:5500", maxAge = 3600)
@CrossOrigin(origins= {"*"}, maxAge = 4800, allowCredentials = "false" )
@Repository
public interface ProductRepository 
    extends JpaRepository<Product, Integer> {
    List<Product> findByManufacturer(String manufacturer);

    Page<Product> findByPriceLessThan(Double price, Pageable page);

    @Query(value = "select * from product order by product_name", nativeQuery = true)
    List<Product> sortByName();
}
