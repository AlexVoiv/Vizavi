package com.vizavi.application.models.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private long productId;
    private String name;
    private String productType;
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    private String description;
    private double price;
}
