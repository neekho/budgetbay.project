package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.budgetbay.repository.CartRepository;
import org.budgetbay.rest.api.CartRequest;
import org.budgetbay.rest.api.CartResponse;
import org.budgetbay.service.CartService;

@ApplicationScoped
public class CartServiceImpl implements CartService {

	@Inject
	private CartRepository cartRepository;

	@Override
	public CartResponse add(CartRequest cartRequest) {
		return null;
	}

	@Override
	public CartResponse get() {
		return null;
	}

	@Override
	public CartResponse get(CartRequest cartRequest) {
		return null;
	}

	@Override
	public CartResponse update(CartRequest cartRequest) {
		return null;
	}

	@Override
	public Response delete(CartRequest cartRequest) {
		return null;
	}
}
