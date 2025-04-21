package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.entity.Category;
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

		Category category = new Category();
		category.setCategoryName(request.categoryName());
		category.setDescription(request.description());

		categoryRepository.persist(category);

		return CategoryResponse.builder()
			.build();

	}

	@Override
	public CategoryResponse get() {

		List<Category> categoriesList = categoryRepository.getAllCategories();

		return CategoryResponse.builder()
			.categoriesList(categoriesList)
			.build();
	}

	@Override
	public CategoryResponse get(CategoryRequest request) {

		List<Category> categories = categoryRepository.getCategoryByName(request.categoryName());

		log.info("Searching for category with label: {}", request.categoryName());

		if (categories.isEmpty()) {
			throw new WebApplicationException("No categories found matching: " + request.categoryName(), Response.Status.NOT_FOUND);
		}

		return CategoryResponse.builder()
			.categoriesList(categories)
			.build();
	}

	@Override
	public CategoryResponse update(CategoryRequest request) {

		Category existingCategory = categoryRepository.findById(request.id());

		if (existingCategory == null)
			throw new WebApplicationException("Category not found", Response.Status.NOT_FOUND);

		existingCategory.setCategoryName(request.categoryName());
		existingCategory.setDescription(request.description());

		return CategoryResponse.builder()
			.categoriesList(List.of(existingCategory))
			.build();
	}

	@Override
	public Response delete(CategoryRequest request) {

		log.info("Removing category with id of ", request.id());

		categoryRepository.deleteById(request.id());

		return Response.status(Response.Status.NO_CONTENT).build();	}
}
