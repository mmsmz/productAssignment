package com.product.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResponsePremiumProductDTO {

    private String status;
    private List<PremiumProductsDTO> list;

}
