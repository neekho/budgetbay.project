package org.budgetbay.rest.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductsRequest {

	public Long id;

	private String productName;
}
