package com.bbcalife.bbcalife.controller;

import com.bbcalife.bbcalife.model.City;
import com.bbcalife.bbcalife.repository.CityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
public class CityController {
    private final CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    @GetMapping("/all")
    @PreAuthorize("hasRole('patient')")
//    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<City>> getAll() {
        List<City> list = cityRepository.findAll();
        return ResponseEntity.ok(list);
    }
}
