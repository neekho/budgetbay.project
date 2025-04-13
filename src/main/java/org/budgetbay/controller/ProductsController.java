package org.budgetbay.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
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
	public ProductsResponse testProducts() {
		return productService.productsResponse(new ProductsRequest("laptops"));
	}


}
