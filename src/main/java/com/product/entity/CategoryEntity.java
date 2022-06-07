package com.product.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter
@Setter
public class CategoryEntity {

    @Id
    @GenericGenerator(name = "sequence_category_id", strategy = "com.product.util.ProductIdGen")
    @GeneratedValue(generator = "sequence_category_id")
    @Column(name = "categoryid")
    private String categoryid;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;


}
