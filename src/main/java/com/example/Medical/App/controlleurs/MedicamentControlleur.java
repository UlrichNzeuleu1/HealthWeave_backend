package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.MedicamentApi;
import com.example.Medical.App.dto.MedicamentDto;
import com.example.Medical.App.services.interfaces.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedicamentControlleur implements MedicamentApi {

    private final MedicamentService medicamentService;

    @Autowired
    public MedicamentControlleur(MedicamentService medicamentService) {
        this.medicamentService = medicamentService;
    }

    @Override
    public MedicamentDto save(MedicamentDto medicamentDto) {
        return medicamentService.save(medicamentDto);
    }

    @Override
    public MedicamentDto findById(Long id) {
        return medicamentService.findById(id);
    }

    @Override
    public MedicamentDto findByNom(String nom) {
        return medicamentService.findByNom(nom);
    }

    @Override
    public List<MedicamentDto> findAll() {
        return medicamentService.findAll();
    }

    @Override
    public MedicamentDto update(Long id, MedicamentDto medicamentDto) {
        return medicamentService.update(id,medicamentDto);
    }

    @Override
    public void delete(Long id) {
        medicamentService.delete(id);
    }
}
