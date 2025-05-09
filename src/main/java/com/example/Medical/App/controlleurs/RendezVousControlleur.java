package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.RendezVousApi;
import com.example.Medical.App.dto.RendezVousDto;
import com.example.Medical.App.services.interfaces.RendezVousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RendezVousControlleur implements RendezVousApi {

    private final RendezVousService service;

    @Autowired
    public RendezVousControlleur(RendezVousService service) {
        this.service = service;
    }

    @Override
    public RendezVousDto save(RendezVousDto rendezVousDto) {
        return service.save(rendezVousDto);
    }

    @Override
    public RendezVousDto findById(Long id) {
        return service.findById(id);
    }

    @Override
    public List<RendezVousDto> findAllByStatut(String statut) {
        return service.findAllByStatut(statut);
    }

    @Override
    public List<RendezVousDto> findAll() {
        return service.findAll();
    }

    @Override
    public RendezVousDto update(Long id, RendezVousDto rendezVousDto) {
        return service.update(id,rendezVousDto);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
