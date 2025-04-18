package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.budgetbay.entity.Categories;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Categories> {

    public List<Categories> getAllCategories() {
        return listAll();
    }

    public Optional<Categories> getCategoryById(Long id) {
        return findByIdOptional(id);
    }

    public Optional<Categories> getCategoryByName(String label) {
        return find("categoryName", label).firstResultOptional();
    }

}
