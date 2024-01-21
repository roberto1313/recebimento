package com.recebimento.api.domain.companies.models;

import com.recebimento.api.domain.base.models.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Getter
@Setter

public class CompanyModel extends BaseModel {
    public String id;
    public String companyName;
    public String fantasyName;
    public String cnpj;
    public String companyAddress;
    public String email;
    public String contactNumber;
    public String status;


    public CompanyModel(String id, String companyName, String fantasyName, String cnpj, String companyAddress, String email, String contactNumber, String status,LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        super(createdAt, updatedAt, deletedAt);
        this.id = id;
        this.companyName = companyName;
        this.fantasyName = fantasyName;
        this.cnpj = cnpj;
        this.companyAddress = companyAddress;
        this.email = email;
        this.contactNumber = contactNumber;
        this.status = status;
    }
}
