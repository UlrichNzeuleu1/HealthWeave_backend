package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.MedecinApi;
import com.example.Medical.App.dto.MedecinDto;
import com.example.Medical.App.services.interfaces.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MedecinControlleur implements MedecinApi {

    private final MedecinService medecinService;

    @Autowired
    public MedecinControlleur(MedecinService medecinService) {
        this.medecinService = medecinService;
    }

    @Override
    public MedecinDto save(MedecinDto medecinDto) {
        return medecinService.save(medecinDto);
    }

    @Override
    public MedecinDto findById(Long id) {
        return medecinService.findById(id);
    }

    @Override
    public List<MedecinDto> findByNom(String nom) {
        return medecinService.findByNom(nom);
    }

    @Override
    public List<MedecinDto> findAll() {
        return medecinService.findAll();
    }

    @Override
    public MedecinDto update(Long id, MedecinDto medecinDto) {
        return medecinService.update(id,medecinDto);
    }

    @Override
    public void delete(Long id) {
        medecinService.delete(id);
    }
}
