package org.budgetbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.budgetbay.statemachine.OrderStatus;

@Data
@Entity
@Table(name = "ORDERS")
@EqualsAndHashCode(callSuper = false)
public class Orders extends Resource {

    private String userId;

    @Column(name = "TOTAL_PRICE", nullable = false)
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private OrderStatus status;

}
