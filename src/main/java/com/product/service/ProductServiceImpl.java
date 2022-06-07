package com.product.service;

import com.product.dto.ProductDTO;
import com.product.dto.ResponseDTO;
import com.product.entity.ProductEntity;
import com.product.repo.ProductRepository;
import com.product.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseDTO createProduct(ProductDTO productDTO) {

        try {
            if (!productDTO.getName().isEmpty() || !productDTO.getDescription().isEmpty() ||
                    productDTO.getPrice() > 0 || !productDTO.getCategoryId().isEmpty()) {

                ProductEntity productEntity = new ProductEntity();
                productEntity.setName(productDTO.getName());
                productEntity.setDescription(productDTO.getDescription());
                productEntity.setPrice(productDTO.getPrice());
                productEntity.setStatus(1); // active
                productEntity.setDateOfLaunch(LocalDate.now());

                productRepository.save(productEntity);
                return ResponseDTO.builder().status(Constant.SUCCESS).build();

            }
            return ResponseDTO.builder().status(Constant.VALIDATION_FAILURE).build();
        } catch (Exception e) {
            return ResponseDTO.builder().status(Constant.ERROR).build();
        }


    }


}
