package com.recebimento.api.domain.places;

import com.recebimento.api.domain.base.entities.BaseEntity;
import com.recebimento.api.domain.places.models.PlaceModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "places")
@EqualsAndHashCode(callSuper = true)
public class Place extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;
    @Column(name = "place_name", length = 100, nullable = false)
    private String PlaceName;
    @Column(name = "company_id", nullable = false)
    private String CompanyId;
    public Place() {}
    public Place(PlaceModel placeModel) {
        PlaceName = placeModel.placeName;
        CompanyId = placeModel.companyId;
    }
    public PlaceModel ToModel() {
        return new PlaceModel(Id, PlaceName, CompanyId, CreatedAt, UpdatedAt, DeletedAt);
    }
    public  void Update(PlaceModel placeModel) {
        PlaceName = placeModel.placeName;
        CompanyId = placeModel.companyId;
    }
}
