package org.budgetbay.service;

import org.budgetbay.rest.api.ProductsRequest;
import org.budgetbay.rest.api.ProductsResponse;

public interface ProductService {
	ProductsResponse productsResponse(ProductsRequest productsRequest);
}
