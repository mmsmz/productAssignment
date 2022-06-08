package com.product.repo;

import com.product.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Integer> {

    List<ProductCategoryEntity> findByCategoryId(String categoryId);

    List<ProductCategoryEntity> findByProductId(String productId);
}
