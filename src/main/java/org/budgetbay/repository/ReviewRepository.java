package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.budgetbay.entity.Reviews;

import java.util.List;

@ApplicationScoped
public class ReviewRepository implements PanacheRepository<Reviews> {

	public List<Reviews> getAllReviews() {
		return listAll();
	}
}
