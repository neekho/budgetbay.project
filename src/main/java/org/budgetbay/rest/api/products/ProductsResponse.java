package org.budgetbay.rest.api.products;

import lombok.Builder;
import lombok.Data;
import org.budgetbay.entity.Review;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class ProductsResponse {

	private List<ProductDTO> products;

	@Data
	@Builder
	public static class ProductDTO {

		private Long id;

		private List<Review> reviews;

		private String productName;

		private String productDescription;

		private BigDecimal price;

	}

}
