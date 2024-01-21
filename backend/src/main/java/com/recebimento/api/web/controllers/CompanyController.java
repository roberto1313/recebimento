package com.recebimento.api.web.controllers;

import com.recebimento.api.domain.companies.ICompanyService;
import com.recebimento.api.domain.companies.models.CompanyModel;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {

    private final ICompanyService companyService;
    public CompanyController(ICompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody CompanyModel companyModel) {
        return companyService.create(companyModel);
    }
    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody CompanyModel companyModel) throws Exception {
        return companyService.update(companyModel);
    }
    @GetMapping("/search")
    public List<CompanyModel> search() {
        return companyService.search();
    }
}
