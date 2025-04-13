package org.budgetbay.rest.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.budgetbay.entity.Products;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductsResponse {

	private List<Products> products;

}
