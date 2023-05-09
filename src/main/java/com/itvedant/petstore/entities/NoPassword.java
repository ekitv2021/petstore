package com.itvedant.petstore.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "noPassword", types = {User.class})
public interface NoPassword {
    String getFirstName();
    String getLastName();
    String getEmail();
    String getMobile();
}
