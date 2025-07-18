package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.FactureApi;
import com.example.Medical.App.dto.FactureDto;
import com.example.Medical.App.services.interfaces.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FactureControlleur implements FactureApi {

    private final FactureService factureService;

    @Autowired
    public FactureControlleur(FactureService factureService) {
        this.factureService = factureService;
    }

    @Override
    public FactureDto save(FactureDto factureDto) {
        return factureService.save(factureDto);
    }

    @Override
    public FactureDto findById(Long idFacture) {
        return factureService.findById(idFacture);
    }

    @Override
    public List<FactureDto> findByStatutPaiement(String statutPaiement) {
        return factureService.findByStatutPaiementContainingIgnoreCase(statutPaiement);
    }

    @Override
    public List<FactureDto> findAll() {
        return factureService.findAll();
    }

    @Override
    public FactureDto update(Long id, FactureDto factureDto) {
        return factureService.update(id,factureDto);
    }

    @Override
    public void delete(Long id) {
        factureService.delete(id);
    }
}
