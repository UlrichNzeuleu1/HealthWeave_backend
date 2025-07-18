package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.DossierMedicalApi;
import com.example.Medical.App.dto.DossierMedicalDto;
import com.example.Medical.App.services.interfaces.DossierMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DossierMedicalControlleur implements DossierMedicalApi {

    private final DossierMedicalService dossierMedicalService;

    @Autowired
    public DossierMedicalControlleur(DossierMedicalService dossierMedicalService) {
        this.dossierMedicalService = dossierMedicalService;
    }

    @Override
    public DossierMedicalDto save(DossierMedicalDto dossierMedicalDto) {
        return dossierMedicalService.save(dossierMedicalDto);
    }

    @Override
    public DossierMedicalDto findById(Long id) {
        return dossierMedicalService.findById(id);
    }

    @Override
    public List<DossierMedicalDto> findByTraitements(String traitement) {
        return dossierMedicalService.findByTraitements(traitement);
    }

    @Override
    public List<DossierMedicalDto> findAll() {
        return dossierMedicalService.findAll();
    }

    @Override
    public DossierMedicalDto update(Long id, DossierMedicalDto updatedDossierMedicalDto) {
        return dossierMedicalService.update(id,updatedDossierMedicalDto);
    }

    @Override
    public void delete(Long id) {
        dossierMedicalService.delete(id);
    }
}
