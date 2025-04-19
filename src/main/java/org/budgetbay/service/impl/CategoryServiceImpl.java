package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.entity.Categories;
import org.budgetbay.repository.CategoryRepository;
import org.budgetbay.rest.api.CategoryRequest;
import org.budgetbay.rest.api.CategoryResponse;
import org.budgetbay.service.CategoryService;

import java.util.List;

@Slf4j
@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public CategoryResponse add(CategoryRequest request) {
		return null;
	}

	@Override
	public CategoryResponse get() {

		List<Categories> categoriesList = categoryRepository.getAllCategories();

		return CategoryResponse.builder()
			.categoriesList(categoriesList)
			.build();
	}

	@Override
	public CategoryResponse get(CategoryRequest request) {

		List<Categories> categories = categoryRepository.getCategoryByName(request.getCategory());

		log.info("Searching for category with label: {}", request.getCategory());

		if (categories.isEmpty()) {
			throw new WebApplicationException("No categories found matching: " + request.getCategory(), Response.Status.NOT_FOUND);
		}

		return CategoryResponse.builder()
			.categoriesList(categories)
			.build();
	}

	@Override
	public CategoryResponse update(CategoryRequest request) {
		return null;
	}

	@Override
	public CategoryResponse delete(CategoryRequest request) {
		return null;
	}
}
