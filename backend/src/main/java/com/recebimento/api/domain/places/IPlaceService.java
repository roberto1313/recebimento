package com.recebimento.api.domain.places;

import com.recebimento.api.domain.places.models.PlaceModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPlaceService {
    ResponseEntity<String> create(PlaceModel placeModel);
    ResponseEntity<String> update(PlaceModel placeModel) throws Exception;
    List<PlaceModel> search();
}
