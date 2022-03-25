package com.companyproject1.contoller;

import com.companyproject1.dto.request.CompanyRequest;
import com.companyproject1.dto.response.CompanyResponse;
import com.companyproject1.entity.Company;
import com.companyproject1.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping()
    public List<CompanyResponse> getALl(){
        return companyService.getAllCompany();
    }

    @PostMapping("/save")
    public CompanyResponse save(@RequestBody CompanyRequest companyRequest) {
        return companyService.save(companyRequest);
    }

    @GetMapping("{id}")
    public Optional<Company> getCompanyById(@PathVariable Long id){
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/delete/{id}")
    public List<CompanyResponse> deleteCompanyById(@PathVariable Long id){
        return companyService.deleteCompany(id);
    }

    @PatchMapping("/update/{id}")
    public CompanyResponse update(@RequestBody CompanyRequest companyRequest, @PathVariable Long id){
        return companyService.updateCompany(id, companyRequest);
    }

    @DeleteMapping("/deleteAllCompany")
    public List<CompanyResponse> deleteAllCompany(){
        return companyService.deleteAllCompany();
    }
}
