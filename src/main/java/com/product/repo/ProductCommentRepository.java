package com.product.repo;

import com.product.entity.ProductCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentRepository extends JpaRepository<ProductCommentEntity, String> {

    List<ProductCommentEntity> findByProductId(String productId);


}