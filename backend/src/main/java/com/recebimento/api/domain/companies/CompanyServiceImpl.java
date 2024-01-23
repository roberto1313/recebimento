package com.recebimento.api.domain.companies;

import com.recebimento.api.domain.companies.models.CompanyModel;
import com.recebimento.api.infra.constants.ReceiptConstants;
import com.recebimento.api.infra.exceptions.ResponseEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements ICompanyService{
    private final ICompanyRepository Repository;
    public CompanyServiceImpl(ICompanyRepository repository) {
        Repository = repository;
    }

    @Override
    public ResponseEntity<String> create(CompanyModel companyModel) {
        if(!validateFormCompany(companyModel)) {
            return ResponseEntityException.getResponseEntityMessage(ReceiptConstants.CREATE_ERROR_MESSAGE, HttpStatus.BAD_REQUEST);
        }
        var company = new Company(companyModel);
        Repository.saveAndFlush(company);
        return ResponseEntityException.getResponseEntityMessage(ReceiptConstants.CREATE_SUCCESS_MESSAGE, HttpStatus.CREATED);
    }
    private boolean validateFormCompany(CompanyModel companyModel) {
        return !companyModel.companyName.isEmpty() &&
                !companyModel.cnpj.isEmpty()
                && !companyModel.email.isEmpty()
                && !companyModel.contactNumber.isEmpty();
    }
    @Override
    public ResponseEntity<String> update(CompanyModel companyModel) throws Exception {
        try {
            var company = getCompany(companyModel);
            company.Update(companyModel);
            Repository.save(company);
            return ResponseEntityException.getResponseEntityMessage(ReceiptConstants.UPDATE_SUCCESS_MESSAGE, HttpStatus.OK);
        }catch (Exception ex) {
            ex.getMessage();
            ResponseEntityException.getException(ReceiptConstants.ERROR_ID_MESSAGE + companyModel.id);
        }
        return ResponseEntityException.getResponseEntityMessage(ReceiptConstants.UPDATE_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private Company getCompany(CompanyModel companyModel) throws Exception {
        var company = Repository.getByKey(companyModel.id);
        if(company == null) {
           ResponseEntityException.getException(ReceiptConstants.ERROR_ID_MESSAGE + companyModel.id);
        }
        return company;
    }
    @Override
    public List<CompanyModel> search() {
        return Repository.search().stream().map(Company::ToModel).toList();
    }
}
