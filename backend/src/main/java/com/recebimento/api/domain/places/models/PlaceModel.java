package com.recebimento.api.domain.places.models;

import com.recebimento.api.domain.base.models.BaseModel;

import java.time.LocalDateTime;

public class PlaceModel extends BaseModel {

    public String id;
    public String placeName;
    public String companyId;

    public PlaceModel(String id, String placeName, String companyId, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt) {
        super(createdAt, updatedAt, deletedAt);
        this.id = id;
        this.placeName = placeName;
        this.companyId = companyId;
    }
}
