package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.MedecinDto;
import com.example.Medical.App.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save (UtilisateurDto dto);
    UtilisateurDto findById (Long id);
    UtilisateurDto findByNom (String nom);
    List<UtilisateurDto> findAll ();
    UtilisateurDto update (Long id, UtilisateurDto utilisateurDto);
    void delete (Long id);
}
