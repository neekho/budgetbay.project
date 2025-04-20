package org.budgetbay.rest.api.products;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductPatchRequest {

	@NotNull(message = "Product ID is required for patching")
	private Long id;

	private String productName;

	private String description;

	private Double price;

	private Integer stock;

	private String imageUrl;
}
