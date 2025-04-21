package org.budgetbay.rest.api.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.budgetbay.entity.Product;
import org.budgetbay.rest.api.products.ProductsResponse;

import java.util.function.Function;

@ApplicationScoped
public class ProductDTOMapper implements Function<Product, ProductsResponse.ProductDTO> {

	@Override
	public ProductsResponse.ProductDTO apply(Product product) {

		return ProductsResponse.ProductDTO.builder()
			.id(product.id)
			.productName(product.getProductName())
			.productDescription(product.getDescription())
			.price(product.getPrice())
			.build();

	}
}
