package com.companyproject1.service.impl;

import com.companyproject1.dto.request.CompanyRequest;
import com.companyproject1.dto.response.CompanyResponse;
import com.companyproject1.entity.Company;
import com.companyproject1.mapper.edit.CompanyEdit;
import com.companyproject1.mapper.view.CompanyView;
import com.companyproject1.repository.CompanyRepository;
import com.companyproject1.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyEdit companyEdit;
    private final CompanyView companyView;
    private final CompanyRepository companyRepository;

    @Override
    public CompanyResponse save(CompanyRequest companyRequest) {
        return companyView.getCompany(companyRepository.save(companyEdit.create(companyRequest)));
    }

    @Override
    public List<CompanyResponse> getAllCompany() {
        List<Company> companyList = companyRepository.findAll();
        return companyView.getCompanyList(companyList);
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = companyRepository.findById(id).get();
        companyEdit.updateCompany(company, companyRequest);
        Company company1 = companyRepository.findById(id).get();
        return companyView.getCompany(company1);
    }

    @Override
    public List<CompanyResponse> deleteCompany(Long id) {
        companyRepository.deleteById(id);
        List<Company> companyList = companyRepository.findAll();
        return companyView.getCompanyList(companyList);
    }

    @Override
    public List<CompanyResponse> deleteAllCompany() {
        companyRepository.deleteAll();
        List<Company>companyList = companyRepository.findAll();
        return companyView.getCompanyList(companyList);
    }
}
