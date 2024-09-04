package com.xlciie.jobapp.review.impl;

import com.xlciie.jobapp.review.Review;
import com.xlciie.jobapp.review.ReviewRepository;
import com.xlciie.jobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
	private final ReviewRepository reviewRepository;

	public ReviewServiceImpl(ReviewRepository reviewRepository) {
		this.reviewRepository = reviewRepository;
	}

	@Override
	public List<Review> findAllReviews() {
		return reviewRepository.findAll();
	}

	@Override
	public Optional<Review> findReviewById(Long id) {
		Optional<Review> reviews = reviewRepository.findById(id);
		if (reviews.isPresent()) {
			return reviews;
		} else {
			throw new RuntimeException("Review with id " + id + " not found");
		}
	}

	@Override
	public void addReview(Review review) {
		review.setReviewDate(LocalDate.now());
		reviewRepository.save(review);
	}

	@Override
	public void updateReview(Long id, Review updatedReview) {
		Optional<Review> existingReview = reviewRepository.findById(id);

		if (existingReview.isPresent()) {
			Review review = existingReview.get();

			review.setRating(updatedReview.getRating());
			review.setRating(updatedReview.getRating());
			review.setComment(updatedReview.getComment());
			review.setReviewerName(updatedReview.getReviewerName());
			review.setReviewDate(LocalDate.now());

			reviewRepository.save(review);
		} else {
			throw new RuntimeException("Review with id " + id + " not found");
		}
	}

	@Override
	public void deleteReview(Long id) {
		Optional<Review> review = reviewRepository.findById(id);

		if (review.isPresent()) {
			reviewRepository.deleteById(id);
		} else {
			throw new RuntimeException("Review with id " + id + " not found");
		}
	}

}