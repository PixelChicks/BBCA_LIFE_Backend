package com.bbcalife.bbcalife.controller;

import com.bbcalife.bbcalife.repository.CountryRepository;
import com.bbcalife.bbcalife.model.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/country")
public class CountryController {
    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Country>> getAll() {
        List<Country> list = countryRepository.findAll();
        return ResponseEntity.ok(list);
    }
}