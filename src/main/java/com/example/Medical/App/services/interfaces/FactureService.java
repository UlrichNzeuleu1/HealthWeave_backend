package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.FactureDto;
import com.example.Medical.App.models.Facture;

import java.util.List;

public interface FactureService {
    FactureDto save (FactureDto factureDto);
    FactureDto findById (Long id);
    List<FactureDto> findAll ();
    List<FactureDto> findByStatutPaiementContainingIgnoreCase(String statutPaiement);
    FactureDto update (Long id, FactureDto factureDto);
    void delete (Long id);
}
