package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.entity.Products;
import org.budgetbay.repository.ProductsRepository;
import org.budgetbay.rest.api.ProductsRequest;
import org.budgetbay.rest.api.ProductsResponse;
import org.budgetbay.service.ProductService;

import java.util.List;
import org.budgetbay.rest.api.ProductsResponse.ProductDTO;

@Slf4j
@ApplicationScoped
public class ProductServiceImpl implements ProductService {

	@Inject
	private ProductsRepository productsRepository;

	@Override
	public ProductsResponse add(ProductsRequest request) {

		// take in new product info base on request (new dto for this?)

		// additional INSERT query in repo layer

		// what response to return if any?

		return ProductsResponse.builder()
			.build();

	}

	@Override
	public ProductsResponse get() {

		log.info("querying database for products");

		return ProductsResponse.builder()
			.products(
				productsRepository.getAllProducts().stream()
					.map(p -> ProductDTO.builder()
						.id(p.id)
						.productName(p.getProductName())
						.productDescription(p.getDescription())
						.price(p.getPrice())
						.build())
					.toList()
			)
			.build();	}

	@Override
	public ProductsResponse get(ProductsRequest request) {

		List<Products> products = productsRepository.getProductByName(request.getProductName());
		log.info("request payload: {}, {}", request.getId(), request.getProductName());

		if (products.isEmpty()) {
			throw new WebApplicationException("No products found matching: " + request.getProductName(), Response.Status.NOT_FOUND);
		}

		List<ProductDTO> productDTO = products.stream()
			.map(p -> ProductDTO.builder()
				.id(p.id)
				.productName(p.getProductName())
				.productDescription(p.getDescription())
				.price(p.getPrice())
				.build())
			.toList();

		return ProductsResponse.builder()
			.products(productDTO)
			.build();
	}

	@Override
	public ProductsResponse update(ProductsRequest request) {
		return null;
	}

	@Override
	public ProductsResponse delete(ProductsRequest request) {
		return null;
	}

}
