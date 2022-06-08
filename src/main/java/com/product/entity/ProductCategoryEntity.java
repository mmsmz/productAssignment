package com.product.entity;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "productcategory")
@Getter
@Setter
public class ProductCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procatid")
    private Integer productCategoryId;

    @Column(name = "productid")
    private String productId;

    @Column(name = "categoryid")
    private String categoryId;


}
