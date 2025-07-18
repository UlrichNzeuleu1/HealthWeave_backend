package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.PatientDto;
import com.example.Medical.App.dto.PersonnelAdministratifDto;

import java.util.List;

public interface PersonnelAdministratifService {
    PersonnelAdministratifDto save (PersonnelAdministratifDto dto);
    PersonnelAdministratifDto findById (Long id);
    List<PersonnelAdministratifDto> findByNom (String nom);
    List<PersonnelAdministratifDto> findByRole (String role);
    List<PersonnelAdministratifDto> findAll ();
    PersonnelAdministratifDto update (Long id, PersonnelAdministratifDto dto);
    void delete (Long id);
}
