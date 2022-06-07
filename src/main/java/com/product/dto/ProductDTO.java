package com.product.dto;


import lombok.Data;

@Data
public class ProductDTO {

    private String name;
    private String description;
    private double price;
    private String categoryId;

}
