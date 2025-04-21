package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.budgetbay.entity.Product;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductsRepository implements PanacheRepository<Product> {

    public List<Product> getAllProducts() {
        return listAll();
    }

    public Optional<Product> getProductById(Long id) {
        return findByIdOptional(id);
    }

    public List<Product> getProductByName(String label) {
        return list("LOWER(productName) LIKE LOWER(?1)", "%" + label + "%");
    }
}
