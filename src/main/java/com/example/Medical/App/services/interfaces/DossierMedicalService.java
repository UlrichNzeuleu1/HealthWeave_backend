package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.DossierMedicalDto;

import java.util.List;

public interface DossierMedicalService {

    DossierMedicalDto save (DossierMedicalDto dossierMedicalDto);
    DossierMedicalDto findById (Long id);
    List<DossierMedicalDto> findAll ();
    DossierMedicalDto update (Long id, DossierMedicalDto dossierMedicalDto);
    void delete (Long id);
}
