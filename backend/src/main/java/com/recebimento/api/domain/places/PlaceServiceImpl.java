package com.recebimento.api.domain.places;

import com.recebimento.api.domain.places.models.PlaceModel;
import com.recebimento.api.infra.constants.ReceiptConstants;
import com.recebimento.api.infra.exceptions.ResponseEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PlaceServiceImpl implements IPlaceService {
    private final IPlaceRepository Repository;
    public PlaceServiceImpl(IPlaceRepository repository) {
        Repository = repository;
    }
    @Override
    public ResponseEntity<String> create(PlaceModel placeModel) {
        if(placeModel.placeName.isEmpty() || placeModel.companyId.isEmpty()) {
            return ResponseEntityException.getResponseEntityMessage(ReceiptConstants.CREATE_ERROR_MESSAGE, HttpStatus.BAD_REQUEST);
        }
        var place = new Place(placeModel);
        Repository.save(place);
        return ResponseEntityException.getResponseEntityMessage(ReceiptConstants.CREATE_SUCCESS_MESSAGE, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<String> update(PlaceModel placeModel) throws Exception {
        try{
            var place = getPlace(placeModel);
            place.Update(placeModel);
            Repository.saveAndFlush(place);
            return ResponseEntityException.getResponseEntityMessage(ReceiptConstants.UPDATE_SUCCESS_MESSAGE, HttpStatus.OK);
        } catch (Exception e) {
            e.getStackTrace();
            ResponseEntityException.getException(ReceiptConstants.ERROR_ID_MESSAGE + placeModel.id);
        }
        return ResponseEntityException.getResponseEntityMessage(ReceiptConstants.UPDATE_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    public List<PlaceModel> search() {
        return Repository.search().stream().map(Place::ToModel).toList();
    }
    private Place getPlace(PlaceModel placeModel) throws Exception {
        var place = Repository.getByKey(placeModel.id);
        if(Objects.isNull(place)) {
            ResponseEntityException.getException(ReceiptConstants.ERROR_ID_MESSAGE + placeModel.id);
        }
        return place;
    }
}
