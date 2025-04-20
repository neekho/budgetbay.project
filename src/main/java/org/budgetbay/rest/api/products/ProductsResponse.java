package org.budgetbay.rest.api.products;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductsResponse {

	private List<ProductDTO> products;

	@Data
	@Builder
	public static class ProductDTO {

		private Long id;

		private String productName;

		private String productDescription;

		private Double price;

	}

}
