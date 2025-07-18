package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.AdresseApi;
import com.example.Medical.App.dto.AdresseDto;
import com.example.Medical.App.dto.AssuranceDto;
import com.example.Medical.App.services.interfaces.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdresseControlleur implements AdresseApi {

    private final AdresseService adresseService;

    @Autowired
    public AdresseControlleur(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @Override
    public AdresseDto save(AdresseDto dto) {
        return adresseService.save(dto);
    }

    @Override
    public AdresseDto findById(Long id) {
        return adresseService.findById(id);
    }

    @Override
    public List<AdresseDto> findAll() {
        return adresseService.findAll();
    }

    @Override
    public ResponseEntity<List<AdresseDto>> findByStreet(String street) {
        List<AdresseDto> adresseDtoList = adresseService.findByStreet(street);
        return ResponseEntity.ok(adresseDtoList);
    }

    @Override
    public void delete(Long id) {
        adresseService.delete(id);
    }

    @Override
    public AdresseDto update(Long id, AdresseDto dto) {
        return adresseService.update(id,dto);
    }
}
