package org.budgetbay.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "ORDER_ITEMS")
@EqualsAndHashCode(callSuper = false)
public class OrderItems extends PanacheEntity {

    //private Orders orderId;

    //private Products userId;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    @Column(name = "PRICE", nullable = false)
    private double price;

}
