package org.budgetbay.error;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		Map<String, String> errors = exception.getConstraintViolations()
			.stream()
			.collect(Collectors.toMap(
				cv -> cv.getPropertyPath().toString(),
				ConstraintViolation::getMessage,
				(msg1, msg2) -> msg1 + ", " + msg2,
				HashMap::new
			));

		return Response.status(Response.Status.BAD_REQUEST)
			.type(MediaType.APPLICATION_JSON)
			.entity(Map.of(
				"error", "Validation failed",
				"details", errors
			))
			.build();	}
}
