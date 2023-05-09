package com.itvedant.petstore.dtos;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
