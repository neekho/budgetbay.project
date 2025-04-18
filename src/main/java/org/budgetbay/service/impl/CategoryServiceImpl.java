package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.budgetbay.entity.Categories;
import org.budgetbay.repository.CategoryRepository;
import org.budgetbay.rest.api.CategoryRequest;
import org.budgetbay.rest.api.CategoryResponse;
import org.budgetbay.service.CategoryService;

import java.util.List;
import java.util.Optional;

@Slf4j
@ApplicationScoped
public class CategoryServiceImpl implements CategoryService {

	@Inject
	private CategoryRepository categoryRepository;

	@Override
	public CategoryResponse categories() {

		List<Categories> categoriesList = categoryRepository.getAllCategories();

		return CategoryResponse.builder()
			.categoriesList(categoriesList)
			.build();
	}

	@Override
	public CategoryResponse categories(CategoryRequest categoryRequest) {

		Optional<Categories> categoriesOptional = categoryRepository.getCategoryByName(categoryRequest.getCategory());
		log.info("request payload: {}, {}", categoryRequest.getId(), categoryRequest.getCategory());

		return categoriesOptional
			.map(category -> CategoryResponse.builder()
				.categoryName(category.getCategoryName())
				.description(category.getDescription())
				.build())
			.orElseThrow(() -> new NotFoundException("Category not found"));
	}

}
