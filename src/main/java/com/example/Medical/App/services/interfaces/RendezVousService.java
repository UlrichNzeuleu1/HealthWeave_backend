package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.PersonnelAdministratifDto;
import com.example.Medical.App.dto.RendezVousDto;

import java.util.List;

public interface RendezVousService {

    RendezVousDto save (RendezVousDto rendezVousDto);
    RendezVousDto findById (Long id);
    RendezVousDto findByStatut (String statut);
    List<RendezVousDto> findAll ();
    RendezVousDto update (Long id, RendezVousDto  rendezVousDto);
    void delete (Long id);
}
