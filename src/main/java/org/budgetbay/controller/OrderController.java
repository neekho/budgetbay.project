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
import org.budgetbay.rest.OrderRequest;
import org.budgetbay.rest.OrderResponse;
import org.budgetbay.service.OrderService;

@Path("/v1/budgetBay/orders")
public class OrderController {

	@Inject
	private OrderService orderService;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OrderResponse add(@Valid OrderRequest request) {
		return orderService.add(request);
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public OrderResponse reviews() {
		return orderService.get();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OrderResponse reviewByName(@Valid OrderRequest request) {
		return orderService.get(request);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public OrderResponse update(@Valid OrderRequest request) {
		return orderService.update(request);
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@Valid OrderRequest request) {
		return orderService.delete(request);
	}


}
