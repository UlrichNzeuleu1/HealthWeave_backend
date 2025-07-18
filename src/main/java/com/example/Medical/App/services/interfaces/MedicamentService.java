package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.MedicamentDto;

import java.util.List;

public interface MedicamentService {

    MedicamentDto save (MedicamentDto medicamentDto);
    MedicamentDto findById (Long id);
    List<MedicamentDto> findByNom (String nom);
    List<MedicamentDto> findAll ();
    MedicamentDto update (Long id, MedicamentDto medicamentDto);
    void delete (Long id);
}
