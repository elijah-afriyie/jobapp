package com.xlciie.jobapp.company;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Company")
@Table(
		name = "company_table",
		uniqueConstraints = {
				@UniqueConstraint(name = "company_website_unique", columnNames = "website"),
				@UniqueConstraint(name = "company_email_unique", columnNames = "email"),
		}
)
public class Company {
	@Id
	@SequenceGenerator(
			name = "company_sequence",
			sequenceName = "company_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = SEQUENCE,
			generator = "company_sequence"
	)
	@Column(name = "id", nullable = false, columnDefinition = "BIGINT")
	private Long id;

	@Column(name = "name", nullable = false, columnDefinition = "TEXT")
	private String name;

	@Column(name = "industry", nullable = false, columnDefinition = "TEXT")
	private String industry;

	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	private String description;

	@Column(name = "address", nullable = false, columnDefinition = "TEXT")
	private String address;

	@Column(name = "website", nullable = false, columnDefinition = "TEXT", unique = true)
	private String website;

	@Column(name = "email", nullable = false, columnDefinition = "TEXT", unique = true)
	private String email;

	@Column(name = "phone", nullable = false, columnDefinition = "TEXT")
	private String phone;

	public Company() {
	}

	public Company(String name, String industry, String description, String address, String website, String email, String phone) {
		this.name = name;
		this.industry = industry;
		this.description = description;
		this.address = address;
		this.website = website;
		this.email = email;
		this.phone = phone;
	}

	public Company(Long id, String name, String industry, String description, String address, String website, String email, String phone) {
		this.id = id;
		this.name = name;
		this.industry = industry;
		this.description = description;
		this.address = address;
		this.website = website;
		this.email = email;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Company{" +
				"id=" + id +
				", name='" + name + '\'' +
				", industry='" + industry + '\'' +
				", description='" + description + '\'' +
				", address='" + address + '\'' +
				", website='" + website + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}
