package com.product.dto;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Data;

@Data
public class ProductDTO {

    private String productId; // used for update

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private double price;
    @Nullable
    private String categoryId;

}
