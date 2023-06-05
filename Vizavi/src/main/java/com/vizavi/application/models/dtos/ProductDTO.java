package com.vizavi.application.models.dtos;

import lombok.Data;
import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private long productId;
    private String name;
    private String description;
    private double price;

}
