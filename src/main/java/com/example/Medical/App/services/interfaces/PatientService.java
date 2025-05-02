package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto save (PatientDto patientDto);
    PatientDto findById (Long id);
    PatientDto findByNom (String nom);
    List<PatientDto> findAll ();
    PatientDto update (Long id, PatientDto patientDto);
    void delete (Long id);
}
