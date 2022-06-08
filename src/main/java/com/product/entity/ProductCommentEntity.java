package com.product.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "productcomment")
@Getter
@Setter
public class ProductCommentEntity {

    @Id
    @Column(name = "productcmntid")
    private String productCommentId;

    @NotNull
    @Column(name = "comment")
    private String comment;

    @NotNull
    @Column(name = "createdTime")
    private String createTime;

    @Column(name = "productid")
    private String productId;

}
