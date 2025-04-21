package org.budgetbay.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.budgetbay.entity.Review;

import java.util.List;

@ApplicationScoped
public class ReviewRepository implements PanacheRepository<Review> {

	public List<Review> getAllReviews() {
		return listAll();
	}
}
