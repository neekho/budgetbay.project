package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.entity.Categories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Categories> {

    public List<Categories> getAllCategories() {
        return listAll();
    }

    public Optional<Categories> getCategoryById(Long id) {
        return findByIdOptional(id);
    }

    public List<Categories> getCategoryByName(String label) {
        log.info("Pattern to search for: %{}%", label);
        if (label == null || label.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String pattern = "%" + label.trim().toLowerCase() + "%";
        return list("LOWER(categoryName) LIKE ?1", pattern);
    }
}
