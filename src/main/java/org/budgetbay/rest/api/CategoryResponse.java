package org.budgetbay.rest.api;

import lombok.Builder;
import lombok.Data;
import org.budgetbay.entity.Categories;

import java.util.List;

@Data
@Builder
public class CategoryResponse {

	private List<Categories> categoriesList;


}
