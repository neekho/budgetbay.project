package org.budgetbay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(name = "CATEGORIES")
@EqualsAndHashCode(callSuper = false)
public class Category extends Resource {

    @OneToMany(mappedBy = "categoryId")
    private List<Product> products;

    @Column(name = "CATEGORY_NAME", nullable = false, updatable = false)
    private String categoryName;

    @Column(name = "DESCRIPTION", nullable = false, updatable = false)
    private String description;

}

