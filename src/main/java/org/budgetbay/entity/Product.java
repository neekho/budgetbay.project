package org.budgetbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@Table(name = "PRODUCTS")
@EqualsAndHashCode(callSuper = false)
public class Product extends Resource {

    @Column(name = "PRODUCT_NAME", nullable = false)
    private String productName;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "IMAGE_URL", nullable = true)
    private String imageUrl;

}
