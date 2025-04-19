package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.budgetbay.entity.Cart;

import java.util.List;

@ApplicationScoped
public class CartRepository implements PanacheRepository<Cart> {

	public List<Cart> getAllReviews() {
		return listAll();
	}
}
