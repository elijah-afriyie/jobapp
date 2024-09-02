package com.xlciie.jobapp.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(path = "/company")
public class CompanyController {
	private final CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping
	public ResponseEntity<List<Company>> findAllCompanies() {
		List<Company> companies = companyService.findAllCompanies();
		return new ResponseEntity<>(companies, HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Company> findCompanyById(@PathVariable Long id) {
		Optional<Company> company = companyService.findCompanyById(id);
		return company.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping
	public ResponseEntity<String> addCompany(@RequestBody Company company) {
		companyService.addCompany(company);
		return new ResponseEntity<>("Company with id " + company.getId() + " created", CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
		companyService.updateCompany(id, company);
		return new ResponseEntity<>("Company with id " + id + " updated", HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		return new ResponseEntity<>("Company with id " + id + " deleted", HttpStatus.OK);
	}

}
