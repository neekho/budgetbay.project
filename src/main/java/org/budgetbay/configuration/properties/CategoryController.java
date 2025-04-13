package org.budgetbay.configuration.properties;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.budgetbay.rest.api.CategoryRequest;
import org.budgetbay.rest.api.CategoryResponse;
import org.budgetbay.service.CategoryService;

@Path("/v1/budgetBay/category")
public class CategoryController {

	@Inject
	private CategoryService categoryService;

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CategoryResponse categories(CategoryRequest request) {
		return categoryService.categories(request);
	}

	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CategoryResponse categoryById(CategoryRequest request) {
		return categoryService.categoryById(request);
	}
}
