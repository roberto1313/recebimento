package com.recebimento.api.web.controllers;

import com.recebimento.api.domain.places.IPlaceService;
import com.recebimento.api.domain.places.models.PlaceModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/places")
public class PlaceController {
    private final IPlaceService placeService;
    public PlaceController(IPlaceService placeService) {this.placeService = placeService; }
    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody PlaceModel placeModel) {
        return placeService.create(placeModel);
    }

    @PutMapping("")
    public ResponseEntity<String> update(@RequestBody PlaceModel placeModel) throws Exception {
        return placeService.update(placeModel);
    }

    @GetMapping("/search")
    public List<PlaceModel> search() {
        return placeService.search();
    }
}
