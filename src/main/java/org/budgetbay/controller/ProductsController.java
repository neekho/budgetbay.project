package org.budgetbay.controller;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.budgetbay.rest.api.ProductsRequest;
import org.budgetbay.rest.api.ProductsResponse;
import org.budgetbay.service.ProductService;

@Path("/v1/budgetBay/products")
public class ProductsController {

	@Inject
	private ProductService productService;

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductsResponse add(@Valid ProductsRequest request) {
		return productService.add(request);
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductsResponse products() {
		return productService.get();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductsResponse productByName(@Valid ProductsRequest request) {
		return productService.get(request);
	}

	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductsResponse update(@Valid ProductsRequest request) {
		return productService.update(request);
	}

	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductsResponse delete(@Valid ProductsRequest request) {
		return productService.delete(request);
	}

}
