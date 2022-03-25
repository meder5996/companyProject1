package com.companyproject1.service;

import com.companyproject1.dto.request.CompanyRequest;
import com.companyproject1.dto.response.CompanyResponse;
import com.companyproject1.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService{

    CompanyResponse save(CompanyRequest companyRequest);

    List<CompanyResponse> getAllCompany();

    Optional<Company> getCompanyById(Long id);

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);

    List<CompanyResponse> deleteCompany(Long id);

    List<CompanyResponse> deleteAllCompany();
}
