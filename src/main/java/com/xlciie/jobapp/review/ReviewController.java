package com.xlciie.jobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {
	public final ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping
	public ResponseEntity<List<Review>> findAllReviews() {
		List<Review> reviews = reviewService.findAllReviews();
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Review> findReviewById(@PathVariable Long id) {
		Optional<Review> review = reviewService.findReviewById(id);
		return review.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<String> addReview(@RequestBody Review review) {
		reviewService.addReview(review);
		return new ResponseEntity<>("Review with id " + review.getId() + " added", CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<String> updateReview(@PathVariable Long id, @RequestBody Review review) {
		reviewService.updateReview(id, review);
		return new ResponseEntity<>("Review with id " + id + " updated", HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable Long id) {
		reviewService.deleteReview(id);
		return new ResponseEntity<>("Review with id " + id + " deleted", HttpStatus.OK);
	}
}
