package com.product.controller;

import com.product.dto.ProductDTO;
import com.product.dto.ResponseDTO;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ResponseDTO> createProduct(@RequestBody ProductDTO productDTO) {

        ResponseDTO responseDTO = productService.createProduct(productDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
}
