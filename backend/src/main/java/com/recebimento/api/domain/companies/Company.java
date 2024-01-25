package com.recebimento.api.domain.companies;

import com.recebimento.api.domain.base.entities.BaseEntity;
import com.recebimento.api.domain.companies.models.CompanyModel;
import com.recebimento.api.domain.places.Place;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "companies")
@Data
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    @Column(name = "company_name", length = 150, nullable = false)
    private String CompanyName;
    @Column(name = "fantasy_name", length = 100)
    private  String FantasyName;
    @Column(name = "cnpj", length = 50, nullable = false)
    private String CNPJ;
    @Column(name = "company_address", length = 150)
    private String CompanyAddress;
    @Column(name = "email", length = 50)
    private String Email;
    @Column(name = "contact_number", length = 50)
    private String ContactNumber;
    @Column(name = "status", length = 10)
    @Pattern(regexp = "Ativo|Inativo")
    private String Status;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Place> Places;
    public Company() {}

    public Company(CompanyModel companyModel) {
        ChangeCompanyName(companyModel.companyName);
        ChangeFantasyName(companyModel.fantasyName);
        ChangeCNPJ(companyModel.cnpj);
        ChangeCompanyAddress(companyModel.companyAddress);
        ChangeEmail(companyModel.email);
        ChangeContactNumberAddress(companyModel.contactNumber);
        ChangeStatus(companyModel.status);
    }

    public void  ChangeCompanyName(String companyName) {
        CompanyName = companyName;
    }
    public void  ChangeFantasyName(String fantasyName) {
        FantasyName = fantasyName;
    }
    public void  ChangeCNPJ(String cnpj) {
        CNPJ = cnpj;
    }
    public void  ChangeCompanyAddress(String companyAddress) {
        CompanyAddress = companyAddress;
    }
    public void  ChangeEmail(String email) { Email = email;  }
    public void  ChangeContactNumberAddress(String contactNumber) {
        ContactNumber = contactNumber;
    }
    public void  ChangeStatus(String status) {
        Status = status != null ? status : "Inativo";
    }
    public void Update(CompanyModel companyModel) {
        ChangeCompanyName(companyModel.companyName);
        ChangeFantasyName(companyModel.fantasyName);
        ChangeCNPJ(companyModel.cnpj);
        ChangeCompanyAddress(companyModel.companyAddress);
        ChangeEmail(companyModel.email);
        ChangeContactNumberAddress(companyModel.contactNumber);
        ChangeStatus(companyModel.status);
        MarkAsUpdated();
    }
    public CompanyModel ToModel() {
        return new CompanyModel(
                Id, CompanyName, FantasyName, CNPJ,
                CompanyAddress, Email, ContactNumber, Status,
                CreatedAt, UpdatedAt, DeletedAt
        );
    }
}
