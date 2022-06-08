package com.product.service;

import com.product.dto.*;
import com.product.entity.CategoryEntity;
import com.product.entity.ProductCategoryEntity;
import com.product.entity.ProductCommentEntity;
import com.product.entity.ProductEntity;
import com.product.repo.CategoryRepository;
import com.product.repo.ProductCategoryRepository;
import com.product.repo.ProductCommentRepository;
import com.product.repo.ProductRepository;
import com.product.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductCommentRepository productCommentRepository;


    @Override
    public ResponseDTO createProduct(ProductDTO productDTO) {

        try {
            if (!productDTO.getName().isEmpty() || !productDTO.getDescription().isEmpty() ||
                    productDTO.getPrice() > 0 || !productDTO.getCategoryId().isEmpty()) {

                ProductEntity productEntity = new ProductEntity();
                productEntity.setName(productDTO.getName());
                productEntity.setDescription(productDTO.getDescription());
                productEntity.setPrice(productDTO.getPrice());
                productEntity.setStatus('A'); // active
                productEntity.setDateOfLaunch(LocalDate.now());
                productRepository.save(productEntity);

                ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();
                productCategoryEntity.setProductId(productEntity.getProductId());
                productCategoryEntity.setCategoryId(productDTO.getCategoryId());
                productCategoryRepository.save(productCategoryEntity);

                return ResponseDTO.builder().status(Constant.SUCCESS).build();
            }
            return ResponseDTO.builder().status(Constant.VALIDATION_FAILURE).build();
        } catch (Exception e) {
            return ResponseDTO.builder().status(Constant.ERROR).build();
        }
    }

    @Override
    public ResponseDTO updateProduct(ProductDTO productDTO) {
        ProductEntity productEntity = productRepository.findByProductId(productDTO.getProductId());

        try {
            if (!productEntity.getProductId().isEmpty()) {
                productEntity.setName(productDTO.getName());
                productEntity.setDescription(productDTO.getDescription());
                productEntity.setPrice(productDTO.getPrice());
                productEntity.setStatus('A'); // active
                productEntity.setDateOfLaunch(LocalDate.now());
                productRepository.save(productEntity);
                return ResponseDTO.builder().status(Constant.SUCCESS).build();
            }
            return ResponseDTO.builder().status(Constant.VALIDATION_FAILURE).build();
        } catch (Exception e) {
            return ResponseDTO.builder().status(Constant.ERROR).build();
        }

    }

    @Override
    public ResponseDTO deleteProduct(String productId) {

        ProductEntity productEntity = productRepository.findByProductId(productId);

        try {
            if (productId.equals(productEntity.getProductId())) {
                productEntity.setStatus('D'); // deActivate
                productRepository.save(productEntity);
                return ResponseDTO.builder().status(Constant.SUCCESS).build();
            }
            return ResponseDTO.builder().status(Constant.VALIDATION_FAILURE).build();
        } catch (Exception e) {
            return ResponseDTO.builder().status(Constant.ERROR).build();
        }
    }

    @Override
    public ResponseAllProducts getProductList(String categoryId) {

        List<AllProductsDTO> listAllProduct = new ArrayList<>();

        try {
            if (!categoryId.isEmpty()) {

                List<ProductCategoryEntity> byProductId = productCategoryRepository.findByCategoryId(categoryId);

                for (ProductCategoryEntity productId : byProductId) {
                    AllProductsDTO allProductsDTO = new AllProductsDTO();

                    CategoryEntity byCategoryid = categoryRepository.findByCategoryid(productId.getCategoryId());
                    allProductsDTO.setCategoryName(byCategoryid.getName());
                    allProductsDTO.setCategoryDescription(byCategoryid.getDescription());

                    ProductEntity productDetail = productRepository.findByProductId(productId.getProductId());

                    if (!productDetail.getProductId().isEmpty()) {
                        allProductsDTO.setProductName(productDetail.getName());
                        allProductsDTO.setProductPrice(productDetail.getPrice());
                        allProductsDTO.setProductDescription(productDetail.getDescription());
                    }

                    List<ProductCommentEntity> productCommentEntityList = productCommentRepository.findByProductId(productId.getProductId());
                    for (ProductCommentEntity commentEntity : productCommentEntityList) {
                        if (commentEntity.getComment()!=null && !commentEntity.getComment().isEmpty()) {
                            allProductsDTO.setComment(commentEntity.getComment());
                            allProductsDTO.setCreateTime(commentEntity.getCreateTime());
                        }
                    }

                    listAllProduct.add(allProductsDTO);
                }

            }

            return ResponseAllProducts.builder().allProductsDTOS(listAllProduct).status(Constant.SUCCESS).build();

        } catch (Exception e) {
            return ResponseAllProducts.builder().status(Constant.ERROR).build();
        }

    }

    @Override
    public ResponsePremiumProductDTO getPremiumProductList() {

        List<PremiumProductsDTO> premiumProductsDTOList = new ArrayList<>();

        try {
            List<ProductEntity> productDetail = productRepository.getPremiumProduct();

                for (ProductEntity productEntity : productDetail) {
                    PremiumProductsDTO premiumProductsDTO = new PremiumProductsDTO();
                    premiumProductsDTO.setProductName(productEntity.getName());
                    premiumProductsDTO.setProductPrice(productEntity.getPrice());
                    premiumProductsDTO.setProductDescription(productEntity.getDescription());

                    List<ProductCategoryEntity> productCategoryEntities = productCategoryRepository.findByProductId(productEntity.getProductId());

                    for(ProductCategoryEntity productCategoryEntity :productCategoryEntities){
                        CategoryEntity categoryEntity = categoryRepository.findByCategoryid(productCategoryEntity.getCategoryId());
                        premiumProductsDTO.setCategoryName(categoryEntity.getName());
                        premiumProductsDTO.setCategoryDescription(categoryEntity.getDescription());
                    }

                    List<ProductCommentEntity> productCommentEntityList = productCommentRepository.findByProductId(productEntity.getProductId());
                    for (ProductCommentEntity commentEntity : productCommentEntityList) {
                        if (commentEntity.getComment()!=null && !commentEntity.getComment().isEmpty()) {
                            premiumProductsDTO.setComment(commentEntity.getComment());
                            premiumProductsDTO.setCreateTime(commentEntity.getCreateTime());
                        }
                    }
                    premiumProductsDTOList.add(premiumProductsDTO);
            }

            return ResponsePremiumProductDTO.builder().list(premiumProductsDTOList).status(Constant.SUCCESS).build();

        } catch (Exception e) {
            return ResponsePremiumProductDTO.builder().status(Constant.ERROR).build();
        }

    }
}
