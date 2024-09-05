package com.xlciie.jobapp.company.impl;

import com.xlciie.jobapp.company.Company;
import com.xlciie.jobapp.company.CompanyRepository;
import com.xlciie.jobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
	private final CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> findAllCompanies() {
		try {
			return companyRepository.findAll();
		} catch (Exception e) {
			throw new RuntimeException("Error finding all companies. Please try again.");
		}
	}

	@Override
	public Optional<Company> findCompanyById(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		if (company.isPresent()) {
			return company;
		} else {
			throw new RuntimeException("Error finding company with id " + id + ". Please try again.");
		}
	}

	@Override
	public void addCompany(Company company) {
		try {
			companyRepository.save(company);
		} catch (Exception e) {
			throw new RuntimeException("Error adding company. Please try again.");
		}
	}

	@Override
	public void updateCompany(Long id, Company updatedCompany) {
		Optional<Company> existingCompany = companyRepository.findById(id);
		if (existingCompany.isPresent()) {
			Company company = existingCompany.get();

			company.setName(updatedCompany.getName());
			company.setIndustry(updatedCompany.getIndustry());
			company.setDescription(updatedCompany.getDescription());
			company.setAddress(updatedCompany.getAddress());
			company.setWebsite(updatedCompany.getWebsite());
			company.setEmail(updatedCompany.getEmail());
			company.setPhone(updatedCompany.getPhone());

			companyRepository.save(company);
		} else {
			throw new RuntimeException("Error updating company. Company with id " + id + " does not exist. Please try again");
		}
	}

	@Override
	public void deleteCompany(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		if (company.isPresent()) {
			companyRepository.delete(company.get());
		} else {
			throw new RuntimeException("Error deleting company. Company with id " + id + " does not exist. Please try again");
		}
	}

}
