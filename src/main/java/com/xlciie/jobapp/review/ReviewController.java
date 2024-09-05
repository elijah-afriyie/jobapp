package com.xlciie.jobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/companies")
public class ReviewController {
	public final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping(path = "/{companyId}/reviews")
	public ResponseEntity<List<Review>> findAllReviews(@PathVariable String companyId) {
		List<Review> reviews = reviewService.findAllReviews();
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	@GetMapping(path = "/{companyId}/reviews/{id}")
	public ResponseEntity<Review> findReviewById(@PathVariable Long id, @PathVariable String companyId) {
		Optional<Review> review = reviewService.findReviewById(id);
		return review.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping(path = "/reviews")
	public ResponseEntity<String> addReview(@RequestBody Review review) {
		reviewService.addReview(review);
		return new ResponseEntity<>("Review with id " + review.getId() + " added", CREATED);
	}

	@PutMapping(path = "/reviews/{id}")
	public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody Review review) {
		reviewService.updateReview(id, review);
		return new ResponseEntity<>("Review with id " + id + " updated", HttpStatus.OK);
	}

	@DeleteMapping(path = "/{companyId}/reviews/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable Long id, @PathVariable String companyId) {
		reviewService.deleteReview(id);
		return new ResponseEntity<>("Review with id " + id + " deleted", HttpStatus.OK);
	}
}
