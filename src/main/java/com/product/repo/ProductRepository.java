package com.product.repo;

import com.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Query(value = "SELECT * FROM product where price > 500", nativeQuery = true)
    List<ProductEntity> getPremiumProduct();

    ProductEntity findByProductId(String productId);


}