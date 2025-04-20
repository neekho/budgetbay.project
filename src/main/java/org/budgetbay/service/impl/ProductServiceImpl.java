package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.entity.Products;
import org.budgetbay.repository.ProductsRepository;
import org.budgetbay.rest.api.products.ProductPatchRequest;
import org.budgetbay.rest.api.products.ProductsRequest;
import org.budgetbay.rest.api.products.ProductsResponse;
import org.budgetbay.service.ProductService;

import java.util.List;
import org.budgetbay.rest.api.products.ProductsResponse.ProductDTO;

@Slf4j
@ApplicationScoped
public class ProductServiceImpl extends AbstractProductService implements ProductService {

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
	@Transactional
	public ProductsResponse update(ProductsRequest request) {

		Products existingProduct = productsRepository.findById(request.getId());

		if (existingProduct == null)
			throw new WebApplicationException("Product not found", Response.Status.NOT_FOUND);


		existingProduct.setProductName(request.getProductName());
		existingProduct.setDescription(request.getDescription());
		existingProduct.setPrice(request.getPrice());
		existingProduct.setStock(request.getStock());
		existingProduct.setImageUrl(request.getImageUrl());

		ProductDTO dto = ProductDTO.builder()
			.id(existingProduct.id)
			.productName(existingProduct.getProductName())
			.productDescription(existingProduct.getDescription())
			.build();

		return ProductsResponse.builder()
			.products(List.of(dto))
			.build();
	}

	@Override
	@Transactional
	public ProductsResponse patch(ProductPatchRequest request) {

		if (request.getId() == null)
			throw new WebApplicationException("Product ID is required", Response.Status.BAD_REQUEST);

		Products existing = productsRepository.findById(request.getId());

		if (existing == null)
			throw new WebApplicationException("Product not found", Response.Status.NOT_FOUND);


		if (request.getProductName() != null) {
			if (request.getProductName().isBlank())
				throw new WebApplicationException("Product name cannot be blank", 400);
			existing.setProductName(request.getProductName());
		}

		if (request.getDescription() != null) {
			if (request.getDescription().isBlank())
				throw new WebApplicationException("Description cannot be blank", 400);

			existing.setDescription(request.getDescription());
		}

		if (request.getPrice() != null) {
			if (request.getPrice() < 0.0)
				throw new WebApplicationException("Price must be zero or positive", 400);

			existing.setPrice(request.getPrice());
		}

		if (request.getStock() != null) {
			if (request.getStock() < 0)
				throw new WebApplicationException("Stock must be 0 or more", 400);
			existing.setStock(request.getStock());
		}


		if (request.getImageUrl() != null)
			existing.setImageUrl(request.getImageUrl());

		productsRepository.persist(existing);

		ProductDTO dto = ProductDTO.builder()
			.id(existing.id)
			.productName(existing.getProductName())
			.productDescription(existing.getDescription())
			.price(existing.getPrice())
			.build();

		return ProductsResponse.builder()
			.products(List.of(dto))
			.build();
	}

	@Override
	@Transactional
	public Response delete(ProductsRequest request) {

		log.info("Removing product with id of ", request.getId());

		productsRepository.deleteById(request.getId());

		return Response.status(Response.Status.NO_CONTENT).build();
	}

}
