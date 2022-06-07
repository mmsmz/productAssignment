package com.product.entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
@Getter
@Setter
public class ProductEntity {

    @Id
    @GenericGenerator(name = "sequence_item_id", strategy = "com.product.util.ProductIdGen")
    @GeneratedValue(generator = "sequence_item_id")
    @Column(name = "productId")
    private String productId;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "price")
    private double price;

    @Nullable
    @Column(name = "dateOfLaunch")
    private LocalDate dateOfLaunch;

}
