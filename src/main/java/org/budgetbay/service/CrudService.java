package org.budgetbay.service;

public interface CrudService<REQUEST, RESPONSE> {
	RESPONSE add(REQUEST request);
	RESPONSE get();
	RESPONSE get(REQUEST request); // optional overloaded get
	RESPONSE update(REQUEST request);
	RESPONSE delete(REQUEST request);
}
