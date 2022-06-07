package com.product.dto;


import lombok.Data;

@Data
public class ProductDTO {

    private String productId; // used for update
    private String name;
    private String description;
    private double price;
    private String categoryId;

}
