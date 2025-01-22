package org.budgetbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "REVIEWS")
@EqualsAndHashCode(callSuper = false)
public class Reviews extends Resource {

    // private Products productId;

    // private Users userId;

    @Column(name = "RATING", nullable = false)
    private int rating;

    @Column(name = "COMMENT", nullable = false)
    private String comment;
    
}
