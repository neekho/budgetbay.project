package org.budgetbay.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
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
	public CategoryResponse categoryById(CategoryRequest categoryRequest) {

		Optional<Categories> categoriesOptional = categoryRepository.getProductById(categoryRequest.getId());

		return CategoryResponse.builder()
			.categoryName(categoriesOptional.get().getCategoryName())
			.description(categoriesOptional.get().getDescription())
			.build();
	}

	@Override
	public CategoryResponse categories(CategoryRequest categoryRequest) {

		List<Categories> categoriesList = categoryRepository.getAllProducts();

		return CategoryResponse.builder()
			.categoriesList(categoriesList)
			.build();
	}
}
