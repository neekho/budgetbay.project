package org.budgetbay.rest.api;

import jakarta.validation.constraints.NotNull;

public record CategoryRequest (

	 Long id,

	 @NotNull
	 String categoryName,

	 String description

) {}
