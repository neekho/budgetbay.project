package org.budgetbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.budgetbay.statemachine.OrderStatus;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "ORDERS")
@EqualsAndHashCode(callSuper = false)
public class Order extends Resource {

    private String userId;

    @Column(name = "TOTAL_PRICE", nullable = false)
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false)
    private OrderStatus status;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @OneToMany(mappedBy = "orderId")
    private List<OrderItem> orderItems;

}
