package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.HopitalApi;
import com.example.Medical.App.dto.HopitalDto;
import com.example.Medical.App.services.interfaces.HopitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HopitalControlleur implements HopitalApi {

    private final HopitalService hopitalService;

    @Autowired
    public HopitalControlleur(HopitalService hopitalService) {
        this.hopitalService = hopitalService;
    }

    @Override
    public HopitalDto save(HopitalDto hopitalDto) {
        return hopitalService.save(hopitalDto);
    }

    @Override
    public HopitalDto findById(Long id) {
        return hopitalService.findById(id);
    }

    @Override
    public List<HopitalDto> findByNom(String nom) {
        return hopitalService.findByNom(nom);
    }

    @Override
    public List<HopitalDto> findAll() {
        return hopitalService.findAll();
    }

    @Override
    public HopitalDto update(Long id, HopitalDto hopitalDto) {
        return hopitalService.update(id,hopitalDto);
    }

    @Override
    public void delete(Long id) {
        hopitalService.delete(id);
    }
}
