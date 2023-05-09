package com.itvedant.petstore.entities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customName" ,types = {User.class})
public interface CustomName {
    @Value("#{target.firstName}" + " " + "#{target.lastName}")
    String getName();

    String getEmail();
    String getMobile();
}
