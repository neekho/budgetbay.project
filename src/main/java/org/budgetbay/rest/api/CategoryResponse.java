package org.budgetbay.rest.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.budgetbay.entity.Categories;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryResponse {

	private List<Categories> categoriesList;

	private String categoryName;

	private String description;

}
