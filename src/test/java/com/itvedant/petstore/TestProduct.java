package com.itvedant.petstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itvedant.petstore.entities.Product;
import com.itvedant.petstore.repositories.ProductRepository;

@SpringBootTest
public class TestProduct {
    @Autowired
    private ProductRepository productRepository;

    // @Test
    // @Order(1)
    // void testCreate(){
    //     Product prod = new Product();
    //     prod.setProductName("EarthBath 2 in 1 Conditioning Shampoo 123456");
    //     prod.setPrice(700.00);
    //     prod.setDescription("EarthBath 2 in 1 Conditioning Shampoo");
    //     prod.setManufacturer("EarthBath");
    //     prod.setManufacturingDate(Instant.now());
    //     productRepository.saveAndFlush(prod);
    //     assertNotNull(productRepository.findById(302).get());
    // }

    @Test
    // @Order(2)
    void testReadAll(){
        List<Product> list = productRepository.findAll();
        boolean condition = list.size() > 0;
	    assertEquals(true, condition);
    }

    // @Test
    // @Order(3)
    // void testReadOne(){
    //     Product product = productRepository.findById(302).get();
	//     assertEquals("EarthBath 2 in 1 Conditioning Shampoo", product.getProductName());
    // }

    // @Test
    // @Order(4)
    // void testUpdate(){
    //     Product p = productRepository.findById(302).get();
	//     p.setPrice(800.00);
	//     productRepository.save(p);
	//     assertNotEquals(700.00, productRepository.findById(302).get().getPrice());
    // }

    // @Test
    // @Order(5)
    // void testDelete(){
    //     productRepository.deleteById(302);
	//     assertEquals(false, productRepository.existsById(302));
    // }
}
