package com.recebimento.api.domain.places;

import com.recebimento.api.domain.companies.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPlaceRepository extends JpaRepository<Place, String> {
    @Query(value = "SELECT * FROM places c WHERE c.deleted_at is null order by c.place_name asc", nativeQuery = true)
    List<Place> search();
    @Query(value = "SELECT *  FROM places c WHERE c.deleted_at is null and c.id =:placeId", nativeQuery = true)
    Place getByKey(@Param("placeId") String id);
}
