package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.repository.ReviewRepository;
import org.budgetbay.rest.api.ReviewRequest;
import org.budgetbay.rest.api.ReviewResponse;
import org.budgetbay.service.ReviewService;

@Slf4j
@ApplicationScoped
public class ReviewServiceImpl implements ReviewService {

	@Inject
	private ReviewRepository reviewRepository;

	@Override
	public ReviewResponse add(ReviewRequest reviewRequest) {
		return null;
	}

	@Override
	public ReviewResponse get() {
		return null;
	}

	@Override
	public ReviewResponse get(ReviewRequest reviewRequest) {
		return null;
	}

	@Override
	public ReviewResponse update(ReviewRequest reviewRequest) {
		return null;
	}

	@Override
	public Response delete(ReviewRequest reviewRequest) {
		return null;
	}
}
