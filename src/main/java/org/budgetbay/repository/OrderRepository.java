package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.budgetbay.entity.Orders;

import java.util.List;

@ApplicationScoped
public class OrderRepository implements PanacheRepository<Orders> {

	public List<Orders> getAllOrders() {
		return listAll();
	}

}
