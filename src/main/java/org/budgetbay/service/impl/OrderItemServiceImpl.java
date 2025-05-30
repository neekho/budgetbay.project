package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.budgetbay.repository.OrderItemsRepository;
import org.budgetbay.rest.api.OrderItemRequest;
import org.budgetbay.rest.api.OrderItemResponse;
import org.budgetbay.service.OrderItemService;

@ApplicationScoped
public class OrderItemServiceImpl implements OrderItemService {

	@Inject
	private OrderItemsRepository orderItemsRepository;

	@Override
	public OrderItemResponse add(OrderItemRequest orderItemRequest) {
		return null;
	}

	@Override
	public OrderItemResponse get() {
		return null;
	}

	@Override
	public OrderItemResponse get(OrderItemRequest orderItemRequest) {
		return null;
	}

	@Override
	public OrderItemResponse update(OrderItemRequest orderItemRequest) {
		return null;
	}

	@Override
	public Response delete(OrderItemRequest orderItemRequest) {
		return null;
	}
}
