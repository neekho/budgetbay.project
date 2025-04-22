package org.budgetbay.controller;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.budgetbay.rest.api.ReviewRequest;
import org.budgetbay.rest.api.ReviewResponse;
import org.budgetbay.service.ReviewService;

@Path("/v1/budgetBay/reviews")
public class ReviewController {

	@Inject
	private ReviewService reviewService;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReviewResponse add(@Valid ReviewRequest request) {
		return reviewService.add(request);
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ReviewResponse reviews() {
		return reviewService.get();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReviewResponse reviewByName(@Valid ReviewRequest request) {
		return reviewService.get(request);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReviewResponse update(@Valid ReviewRequest request) {
		return reviewService.update(request);
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@Valid ReviewRequest request) {
		return reviewService.delete(request);
	}




}
