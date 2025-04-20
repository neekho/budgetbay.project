package org.budgetbay.service;

import jakarta.ws.rs.core.Response;

public interface CrudService<REQUEST, RESPONSE> {
	RESPONSE add(REQUEST request);
	RESPONSE get();
	RESPONSE get(REQUEST request); // optional overloaded get
	RESPONSE update(REQUEST request);
	Response delete(REQUEST request);
}
