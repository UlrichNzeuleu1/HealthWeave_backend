package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.AdresseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdresseService {

    AdresseDto save(AdresseDto dto);
    AdresseDto findById(Long id);
    List<AdresseDto> findAll();
    AdresseDto update(Long id, AdresseDto dto);
    void delete(Long id);
    List<AdresseDto> findByStreet(String street);
}
