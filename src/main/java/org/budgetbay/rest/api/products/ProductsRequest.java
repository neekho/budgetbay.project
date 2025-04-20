package org.budgetbay.rest.api.products;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductsRequest {

	private Long id;

	@NotNull
	private String productName;

	@Size(max = 200, message = "Description can be up to 500 characters long")
	private String description;

	@NotNull(message = "Price is required")
	@PositiveOrZero(message = "Price must be zero or a positive value")
	private Double price;

	@Min(value = 0, message = "Stock must be 0 or more")
	private Integer stock;

	@Size(max = 2048, message = "Image URL is too long")
	@Pattern(
		regexp = "^(http[s]?://.*)|(\\s*)$",
		message = "Image URL must be a valid URL or empty"
	)
	private String imageUrl;
}
