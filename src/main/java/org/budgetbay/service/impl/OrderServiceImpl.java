package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.budgetbay.repository.OrderRepository;
import org.budgetbay.rest.api.OrderRequest;
import org.budgetbay.rest.api.OrderResponse;
import org.budgetbay.service.OrderService;

@ApplicationScoped
public class OrderServiceImpl implements OrderService {

	@Inject
	private OrderRepository orderRepository;

	@Override
	public OrderResponse add(OrderRequest orderRequest) {
		return null;
	}

	@Override
	public OrderResponse get() {
		return null;
	}

	@Override
	public OrderResponse get(OrderRequest orderRequest) {
		return null;
	}

	@Override
	public OrderResponse update(OrderRequest orderRequest) {
		return null;
	}

	@Override
	public Response delete(OrderRequest orderRequest) {
		return null;
	}
}
