package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class OrderItemsRepository implements PanacheRepository<OrderItemsRepository> {

	public List<OrderItemsRepository> getAllReviews() {
		return listAll();
	}

}
