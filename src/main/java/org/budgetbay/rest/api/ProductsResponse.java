package org.budgetbay.rest.api;

import lombok.Builder;
import lombok.Data;
import org.budgetbay.entity.Products;

import java.util.List;

@Data
@Builder
public class ProductsResponse {

	private List<Products> products;

}
