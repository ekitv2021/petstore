package com.itvedant.petstore;

import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.itvedant.petstore.entities.Product;

@RepositoryEventHandler(Product.class)
public class RequestHandler {
    @HandleBeforeSave
    public void handleAuthorBeforeCreate(Product product){
        System.out.println("........................handler............................");
    }
}
