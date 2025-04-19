package org.budgetbay.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
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

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductsResponse products() {
		return productService.getProducts();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductsResponse productByName(ProductsRequest request) {
		return productService.getProducts(request);
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ProductsResponse add(ProductsRequest request) {
		return productService.getProducts(request);
	}




}
