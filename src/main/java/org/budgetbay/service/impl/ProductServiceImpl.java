package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.entity.Products;
import org.budgetbay.repository.ProductsRepository;
import org.budgetbay.rest.api.ProductsRequest;
import org.budgetbay.rest.api.ProductsResponse;
import org.budgetbay.service.ProductService;

import java.util.List;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductsRepository productsRepository;

	@Override
	public ProductsResponse getProducts() {

		log.info("querying database for products");

		return ProductsResponse.builder()
			.products(productsRepository.getAllProducts())
			.build();

	}

	@Override
	public ProductsResponse getProducts(ProductsRequest productsRequest) {

		List<Products> products = productsRepository.getProductByName(productsRequest.getProductName());
		log.info("request payload: {}, {}", productsRequest.getId(), productsRequest.getProductName());

		if (products.isEmpty()) {
			throw new WebApplicationException("No products found matching: " + productsRequest.getProductName(), Response.Status.NOT_FOUND);
		}

		return ProductsResponse.builder()
			.products(products)
			.build();
	}

}
