package com.xlciie.jobapp.job;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.xlciie.jobapp.company.Company;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Job")
@Table(name = "job_table")
public class Job {
	@Id
	@SequenceGenerator(
			name = "job_sequence",
			sequenceName = "job_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = SEQUENCE,
			generator = "job_sequence"
	)
	@Column(name = "id", nullable = false, columnDefinition = "BIGINT")
	private Long id;

	@Column(name = "title", nullable = false, columnDefinition = "TEXT")
	private String title;

	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(name = "min_salary", nullable = false, columnDefinition = "TEXT")
	private String minSalary;

	@Column(name = "max_salary", nullable = false, columnDefinition = "TEXT")
	private String maxSalary;

	@Column(name = "location", nullable = false, columnDefinition = "TEXT")
	private String location;

	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	@JsonBackReference
	private Company company;

	public Job() {
	}

	public Job(String title, String description, String minSalary, String maxSalary, String location) {
		this.title = title;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.location = location;
	}

	public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}

	public String getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Job{" +
				"id=" + id +
				", title='" + title + '\'' +
				", description='" + description + '\'' +
				", minSalary='" + minSalary + '\'' +
				", maxSalary='" + maxSalary + '\'' +
				", location='" + location + '\'' +
				'}';
	}
}
