package com.product.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productcomment")
@Getter
@Setter
public class ProductCommentEntity {

    @Id
    @Column(name = "productcmntid")
    private String productCommentId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "createdTime")
    private String createTime;

    @Column(name = "productid")
    private String productId;

}
