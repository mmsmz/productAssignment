package com.product.service;

import com.product.dto.ResponsePremiumProductDTO;
import com.product.dto.ProductDTO;
import com.product.dto.ResponseAllProducts;
import com.product.dto.ResponseDTO;

public interface ProductService {
    ResponseDTO createProduct(ProductDTO productDTO);

    ResponseDTO updateProduct(ProductDTO productDTO);

    ResponseDTO deleteProduct(String productId);

    ResponseAllProducts getProductList(String categoryId);

    ResponsePremiumProductDTO getPremiumProductList();
}
