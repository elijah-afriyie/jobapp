package com.xlciie.jobapp.review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
	List<Review> findAllReviews();

	Optional<Review> findReviewById(Long id);

	void addReview(Review review);

	void updateReview(Long id, Review review);

	void deleteReview(Long id);
}