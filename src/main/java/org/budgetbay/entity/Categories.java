package org.budgetbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "CATEGORIES")
@EqualsAndHashCode(callSuper = false)
public class Categories extends Resource {

    @Column(name = "CATEGORY_NAME", nullable = false, updatable = false)
    private String categoryName;

    @Column(name = "DESCRIPTION", nullable = false, updatable = false)
    private String description;

}

