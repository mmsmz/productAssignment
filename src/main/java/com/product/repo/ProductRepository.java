package com.product.repo;

import com.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

//  @Modifying
//  @Query(value = "Update customer set void_invoice =1 where invoice_No=?1", nativeQuery = true)
//  int voidInvoice(String invoiceNo);

    ProductEntity findByProductId(String productId);



}