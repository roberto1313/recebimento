package com.recebimento.api.domain.companies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ICompanyRepository extends JpaRepository<Company, String> {
    @Query(value = "SELECT * FROM companies c WHERE c.deleted_at is null order by c.company_name asc", nativeQuery = true)
    List<Company> search();

    @Query(value = "SELECT *  FROM companies c WHERE c.deleted_at is null and c.id =:companyId", nativeQuery = true)
    Company getByKey(@Param("companyId") String id);
}
