package com.product.controller;

import com.product.dto.ProductDTO;
import com.product.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @PostMapping("/product")
    public ResponseEntity<ResponseDTO> createProduct(@RequestBody ProductDTO productDTO) {

        ResponseDTO responseDTO =

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);

    }
}
