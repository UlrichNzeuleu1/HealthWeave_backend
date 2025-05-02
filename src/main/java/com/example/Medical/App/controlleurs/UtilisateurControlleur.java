package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.UtilisateurApi;
import com.example.Medical.App.dto.UtilisateurDto;
import com.example.Medical.App.services.interfaces.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurControlleur implements UtilisateurApi {

    private final UtilisateurService service;

    @Autowired
    public UtilisateurControlleur(UtilisateurService service) {
        this.service = service;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        return service.save(utilisateurDto);
    }

    @Override
    public UtilisateurDto findById(Long id) {
        return service.findById(id);
    }

    @Override
    public UtilisateurDto findByNom(String nom) {
        return service.findByNom(nom);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return service.findAll();
    }

    @Override
    public UtilisateurDto update(Long id, UtilisateurDto utilisateurDto) {
        return service.update(id,utilisateurDto);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }
}
