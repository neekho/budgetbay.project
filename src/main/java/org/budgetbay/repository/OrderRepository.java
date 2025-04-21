package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.budgetbay.entity.Order;

import java.util.List;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Order> {

	public List<Order> getAllOrders() {
		return listAll();
	}

}
