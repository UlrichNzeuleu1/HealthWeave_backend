package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.MedecinDto;

import java.util.List;

public interface MedecinService {
    MedecinDto save (MedecinDto medecinDto);
    MedecinDto findById (Long id);
    MedecinDto findByNom (String nom);
    MedecinDto findBySpecialite (String specialite);
    List<MedecinDto> findAll ();
    MedecinDto update (Long id, MedecinDto medecinDto);
    void delete (Long id);
}
