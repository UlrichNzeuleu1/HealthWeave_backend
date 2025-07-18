package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.PersonnelAdministratifApi;
import com.example.Medical.App.dto.PersonnelAdministratifDto;
import com.example.Medical.App.services.interfaces.PersonnelAdministratifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonnelAdministratifControlleur implements PersonnelAdministratifApi {

    private final PersonnelAdministratifService administratifService;

    @Autowired
    public PersonnelAdministratifControlleur(PersonnelAdministratifService administratifService) {
        this.administratifService = administratifService;
    }


    @Override
    public PersonnelAdministratifDto save(PersonnelAdministratifDto dto) {
        return administratifService.save(dto);
    }

    @Override
    public PersonnelAdministratifDto findById(Long id) {
        return administratifService.findById(id);
    }

    @Override
    public List<PersonnelAdministratifDto> findByNom(String nom) {
        return administratifService.findByNom(nom);
    }

    @Override
    public List<PersonnelAdministratifDto> findByRole(String role) {
        return administratifService.findByRole(role);
    }

    @Override
    public List<PersonnelAdministratifDto> findAll() {
        return administratifService.findAll();
    }

    @Override
    public PersonnelAdministratifDto update(Long id, PersonnelAdministratifDto dto) {
        return administratifService.update(id,dto);
    }

    @Override
    public void delete(Long id) {
        administratifService.delete(id);
    }
}
