package com.itvedant.petstore.dtos;

import java.time.Instant;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateProductDto {
    @NotNull
    @Size(min = 5, message = "Product name should that 5 or more characters")
    private String productName;

    @NotNull
    @PastOrPresent(message = "Manufacturing date should be either today's date or past date")
    private Instant manufacturingDate;

    @NotNull
    @Size(min = 5, message = "Manufacturer name should that 5 or more characters")
    private String manufacturer;

    @NotNull
    @Min(value = 1, message = "Price value should be more than 0")
    private Double price;

    @NotNull
    @Size(min = 5, message = "Description should that 5 or more characters")
    private String description;

    private String imageUrl;
}
