package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
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
	@Transactional
	public ProductsResponse add(ProductsRequest request) {

		double price = request.getPrice() != null ? request.getPrice() : 0.0;
		int stock = request.getStock() != null ? request.getStock() : 0;

		Products product = new Products();
		product.setProductName(request.getProductName());
		product.setDescription(request.getDescription());
		product.setPrice(price);
		product.setStock(stock);
		product.setImageUrl(request.getImageUrl());

		productsRepository.persist(product);

		ProductDTO dto = ProductDTO.builder()
			.id(product.id)
			.productName(product.getProductName())
			.productDescription(product.getDescription())
			.build();

		return ProductsResponse.builder()
			.products(List.of(dto))
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

		productsRepository.deleteById(request.getId());

		return ProductsResponse.builder()
			.build();
	}

}
