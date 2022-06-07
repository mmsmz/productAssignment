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
    @GenericGenerator(name = "sequence_poductcmnt_id", strategy = "com.product.util.ProductIdGen")
    @GeneratedValue(generator = "sequence_poductcmnt_id")
    @Column(name = "productcmntid")
    private String productCommentId;

    @NotNull
    @Column(name = "comment")
    private String comment;

    @NotNull
    @Column(name = "description")
    private String description;

}
