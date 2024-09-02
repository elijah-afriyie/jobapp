package com.xlciie.jobapp.company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
	List<Company> findAllCompanies();

	Optional<Company> findCompanyById(Long id);

	void addCompany(Company company);

	void updateCompany(Long id, Company company);

	void deleteCompany(Long id);
}
