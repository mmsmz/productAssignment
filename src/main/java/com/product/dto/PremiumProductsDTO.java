package com.product.dto;

import lombok.Data;

@Data
public class PremiumProductsDTO {

    // product table
    private String productName;
    private String productDescription;
    private double productPrice;

    // category table
    private String categoryName;
    private String categoryDescription;

    // comment table - if any listing only that
    private String comment;
    private String createTime;

}
