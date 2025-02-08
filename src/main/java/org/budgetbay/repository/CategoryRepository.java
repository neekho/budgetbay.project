package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.budgetbay.entity.Categories;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryRepository implements PanacheRepository<Categories> {

    public List<Categories> getAllProducts() {
        return listAll();
    }

    public Optional<Categories> getProductById(Long id) {
        return findByIdOptional(id);
    }


}
