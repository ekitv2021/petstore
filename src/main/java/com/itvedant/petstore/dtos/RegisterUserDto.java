package com.itvedant.petstore.dtos;

import java.util.List;

import com.itvedant.petstore.validators.PhoneNumber;
import com.itvedant.petstore.validators.VerifyPassword;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@VerifyPassword(
    field = "password",
    matchingField = "confirmPassword"
)
public class RegisterUserDto {
    @NotNull
    @Size(min = 3, message = "First Name should be greater than 3 characters")
    private String firstName;

    @NotNull
    @Size(min = 3, message = "Last Name should be greater than 3 characters")
    private String lastName;

    @NotNull
    @Email    
    private String email;

    @NotNull
    @Size(min = 6, max = 20, message = "Password should be between 6 and 20 characters")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "Password can contain only alphanumeric characters")
    private String password;

    private String confirmPassword;

    @PhoneNumber
    private String mobile; 

    private List<String> roles;
}
