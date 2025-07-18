package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.CompteApi;
import com.example.Medical.App.dto.CompteDto;
import com.example.Medical.App.services.interfaces.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompteControlleur implements CompteApi {

    private final CompteService compteService;

    @Autowired
    public CompteControlleur(CompteService compteService) {
        this.compteService = compteService;
    }

    @Override
    public CompteDto save(CompteDto compteDto) {
        return compteService.save(compteDto);
    }

    @Override
    public CompteDto findById(Long id) {
        return compteService.findById(id);
    }

    @Override
    public List<CompteDto> findAll() {
        return compteService.findAll();
    }

    @Override
    public ResponseEntity<List<CompteDto>> findByEmail(String email) {
        List<CompteDto> compteDtoList =  compteService.findByEmail(email);
        return ResponseEntity.ok(compteDtoList);
    }

    @Override
    public CompteDto update(Long id, CompteDto compteDto) {
        return compteService.update(id,compteDto);
    }

    @Override
    public void delete(Long id) {
        compteService.delete(id);
    }
}
