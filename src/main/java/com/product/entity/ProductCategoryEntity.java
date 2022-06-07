package com.product.entity;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productcategory")
@Getter
@Setter
public class ProductCategoryEntity {

    @Id
    @Column(name = "procatid")
    private String productCategoryId;

    @Column(name = "productid")
    private String productId;

    @Column(name = "categoryid")
    private String categoryId;


}
