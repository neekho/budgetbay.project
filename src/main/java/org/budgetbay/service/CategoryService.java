package org.budgetbay.service;

import org.budgetbay.rest.api.CategoryRequest;
import org.budgetbay.rest.api.CategoryResponse;

public interface CategoryService {
	CategoryResponse categoryById(CategoryRequest categoryRequest);
	CategoryResponse categories(CategoryRequest categoryRequest);
}
