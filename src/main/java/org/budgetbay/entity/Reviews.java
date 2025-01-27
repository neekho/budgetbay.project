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
public class Reviews extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Products productId;

    private String userId;

    @Column(name = "RATING", nullable = false)
    private int rating;

    @Column(name = "COMMENT", nullable = false)
    private String comment;
    
}
