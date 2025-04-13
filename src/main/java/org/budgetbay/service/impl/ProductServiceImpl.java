package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.repository.ProductsRepository;
import org.budgetbay.rest.api.ProductsRequest;
import org.budgetbay.rest.api.ProductsResponse;
import org.budgetbay.service.ProductService;

@Slf4j
@ApplicationScoped
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductsRepository productsRepository;

	@Override
	public ProductsResponse productsResponse(ProductsRequest productsRequest) {

		log.info("querying database for products");

		return new ProductsResponse(productsRepository.getAllProducts());
	}
}
