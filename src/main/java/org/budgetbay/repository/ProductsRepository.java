package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.budgetbay.entity.Products;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductsRepository implements PanacheRepository<Products> {

    public List<Products> getAllProducts() {
        return listAll();
    }

    public Optional<Products> getProductById(Long id) {
        return findByIdOptional(id);
    }

    public List<Products> getProductByName(String label) {
        return list("LOWER(productName) LIKE LOWER(?1)", "%" + label + "%");
    }
}
