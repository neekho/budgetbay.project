package org.budgetbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "REVIEWS")
@EqualsAndHashCode(callSuper = false)
public class Review extends Resource {

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id")
    private Product productId;

    @Column(name = "RATING", nullable = false)
    private Integer rating;

    @Column(name = "COMMENT", nullable = false)
    private String comment;

}
