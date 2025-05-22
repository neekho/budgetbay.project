package org.budgetbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;
import java.util.List;

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
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "id")
    private Category categoryId;

    @OneToMany(mappedBy = "productId")
    private List<Review> reviews;

    @OneToMany(mappedBy = "productId")
    private List<Cart> carts;

    @OneToMany(mappedBy = "productId")
    private List<OrderItem> orderItems;

    @Column(name = "STOCK", nullable = false)
    private Integer stock;

    @Column(name = "IMAGE_URL", nullable = true)
    private String imageUrl;

}
