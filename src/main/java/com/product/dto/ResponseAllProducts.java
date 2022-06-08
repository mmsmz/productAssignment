package com.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ResponseAllProducts {

    private String status;
    List<AllProductsDTO> allProductsDTOS;

    public ResponseAllProducts() {
        this.allProductsDTOS = new ArrayList<>();
    }
}
