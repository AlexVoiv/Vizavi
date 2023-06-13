package com.vizavi.application.models.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private long productId;

    @NotBlank(message = "name must not be blank")
    private String name;

    @NotBlank(message = "productType must not be blank")
    private String type;
    @NotBlank(message = "description must not be blank")
    private String description;

    @NotBlank(message = "price must not be blank")
    private double price;

}
