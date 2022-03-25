package com.companyproject1.mapper.view;

import com.companyproject1.dto.response.CompanyResponse;
import com.companyproject1.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyView {

    public CompanyResponse getCompany(Company company) {
        if (company == null) {
            return null;
        } else {
            CompanyResponse companyResponse = new CompanyResponse();
            if (company.getId() != null) {
                companyResponse.setId(String.valueOf(company.getId()));
            }
            companyResponse.setCompanyName(company.getCompanyName());
            companyResponse.setLocatedCountry(company.getLocatedCountry());
            companyResponse.setCourseList(company.getCourseList());
            return companyResponse;
        }
    }

    public List<CompanyResponse> getCompanyList(List<Company> companyList) {
        List<CompanyResponse> responseList = new ArrayList<>();
        for (Company company : companyList) {
            responseList.add(getCompany(company));
        }
        return responseList;
    }
}
