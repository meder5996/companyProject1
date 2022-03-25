package com.companyproject1.mapper.edit;

import com.companyproject1.dto.request.CompanyRequest;
import com.companyproject1.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyEdit {

    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        } else {
            Company company = new Company();
            company.setCompanyName(companyRequest.getCompanyName());
            company.setLocatedCountry(companyRequest.getLocatedCountry());
            return company;
        }
    }

    public void updateCompany(Company company, CompanyRequest companyRequest) {
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
    }
}
