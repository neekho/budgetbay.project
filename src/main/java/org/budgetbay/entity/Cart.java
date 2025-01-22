package org.budgetbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "CART")
@EqualsAndHashCode(callSuper = false)
public class Cart extends Resource {

    //private User userId;

    //private Products productId;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

}
