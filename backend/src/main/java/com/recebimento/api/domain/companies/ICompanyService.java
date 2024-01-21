package com.recebimento.api.domain.companies;

import com.recebimento.api.domain.companies.models.CompanyModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICompanyService {
    ResponseEntity<String> create(CompanyModel companyModel);
    ResponseEntity<String> update(CompanyModel companyModel) throws Exception;
    List<CompanyModel> search();
}
