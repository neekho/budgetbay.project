package org.budgetbay.service;

import org.budgetbay.rest.api.products.ProductPatchRequest;
import org.budgetbay.rest.api.products.ProductsRequest;
import org.budgetbay.rest.api.products.ProductsResponse;

public interface ProductService extends CrudService<ProductsRequest, ProductsResponse>{
	ProductsResponse patch(ProductPatchRequest request);

}
