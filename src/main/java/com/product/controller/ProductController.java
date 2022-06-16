package com.product.controller;

import com.product.dto.ProductDTO;
import com.product.dto.ResponseAllProducts;
import com.product.dto.ResponseDTO;
import com.product.dto.ResponsePremiumProductDTO;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    /** create a product */
    @PostMapping("/product")
    public ResponseEntity<ResponseDTO> createProduct(@Validated @RequestBody ProductDTO productDTO) {
        ResponseDTO responseDTO = productService.createProduct(productDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    /** update a product */
    @PatchMapping("/product")
    public ResponseEntity<ResponseDTO> updateProduct(@Validated @RequestBody ProductDTO productDTO) {
        ResponseDTO responseDTO = productService.updateProduct(productDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /** soft delete a product */
    @DeleteMapping("/product")
    public ResponseEntity<ResponseDTO> deleteProduct(@RequestParam String productId) {
        ResponseDTO responseDTO = productService.deleteProduct(productId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /** Retrieve all the products in a given category */
    @GetMapping("/listAllProducts")
    public ResponseEntity<ResponseAllProducts> getProductList(@RequestParam String categoryId) {
        ResponseAllProducts responseDTO = productService.getProductList(categoryId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    /**    5. Retrieve all premium products (products whose price is more than or
        equal to $500) */
    @GetMapping("/listAllPremiumProducts")
    public ResponseEntity<ResponsePremiumProductDTO> getPremiumProductList() {
        ResponsePremiumProductDTO responseDTO = productService.getPremiumProductList();
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }



}
