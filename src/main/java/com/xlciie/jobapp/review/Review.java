package com.xlciie.jobapp.review;

import jakarta.persistence.*;

import java.util.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Review")
@Table(name = "review_table")
public class Review {
	@Id
	@SequenceGenerator(
			name = "review_sequence",
			sequenceName = "review_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = SEQUENCE,
			generator = "review_sequence"
	)
	@Column(name = "id", nullable = false, columnDefinition = "BIGINT")
	private Long id;

	@Column(name = "company_id", nullable = false, columnDefinition = "BIGINT")
	private Integer companyId;

	@Column(name = "rating", nullable = false, columnDefinition = "TEXT")
	private Integer rating;

	@Column(name = "comment", nullable = false, columnDefinition = "TEXT")
	private String comment;

	@Column(name = "reviewer_name", nullable = false, columnDefinition = "TEXT")
	private String reviewerName;

	@Column(name = "review_date", nullable = false, columnDefinition = "DATE")
	private Date reviewDate;

	public Review() {
	}

	public Review(Integer companyId, Integer rating, String comment, String reviewerName, Date reviewDate) {
		this.companyId = companyId;
		this.rating = rating;
		this.comment = comment;
		this.reviewerName = reviewerName;
		this.reviewDate = reviewDate;
	}

	public Review(Long id, Integer companyId, Integer rating, String comment, String reviewerName, Date reviewDate) {
		this.id = id;
		this.companyId = companyId;
		this.rating = rating;
		this.comment = comment;
		this.reviewerName = reviewerName;
		this.reviewDate = reviewDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getReviewerName() {
		return reviewerName;
	}

	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Override
	public String toString() {
		return "Review{" +
				"id=" + id +
				", companyId=" + companyId +
				", rating=" + rating +
				", comment='" + comment + '\'' +
				", reviewerName='" + reviewerName + '\'' +
				", reviewDate=" + reviewDate +
				'}';
	}
}
