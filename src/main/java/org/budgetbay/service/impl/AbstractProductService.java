package org.budgetbay.service.impl;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

import java.util.function.Consumer;

public class AbstractProductService {

	void updateIfNotBlank(String field, String fieldName, Consumer<String> setter) {
		if (field != null) {
			if (field.isBlank())
				throw new WebApplicationException(fieldName + " cannot be blank", Response.Status.BAD_REQUEST);
			setter.accept(field);
		}
	}

	void updateIfNonNegative(Double field, String fieldName, Consumer<Double> setter) {
		if (field != null) {
			if (field < 0.0)
				throw new WebApplicationException(fieldName + " must be zero or positive", Response.Status.BAD_REQUEST);
			setter.accept(field);
		}
	}

	private void updateIfNonNegative(Integer field, String fieldName, Consumer<Integer> setter) {
		if (field != null) {
			if (field < 0)
				throw new WebApplicationException(fieldName + " must be zero or positive", Response.Status.BAD_REQUEST);
			setter.accept(field);
		}
	}

}
