package org.budgetbay.service;

import org.budgetbay.rest.api.ProductsRequest;
import org.budgetbay.rest.api.ProductsResponse;

public interface ProductService {
	ProductsResponse add(ProductsRequest request);
	ProductsResponse getProducts();
	ProductsResponse getProducts(ProductsRequest request);
}
