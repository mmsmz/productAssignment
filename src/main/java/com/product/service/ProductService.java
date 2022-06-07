package com.product.service;

import com.product.dto.ProductDTO;
import com.product.dto.ResponseDTO;

public interface ProductService {
    ResponseDTO createProduct(ProductDTO productDTO);
}
