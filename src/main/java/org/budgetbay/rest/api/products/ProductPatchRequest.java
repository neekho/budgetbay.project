package org.budgetbay.rest.api.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductPatchRequest {

	@NotNull(message = "Product ID is required for patching")
	private Long id;

	private String productName;

	private String description;

	@PositiveOrZero(message = "Price must be zero or a positive value")
	private BigDecimal price;

	private Integer stock;

	private String imageUrl;
}
