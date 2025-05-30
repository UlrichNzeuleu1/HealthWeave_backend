package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.PatientApi;
import com.example.Medical.App.dto.PatientDto;
import com.example.Medical.App.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PatientControlleur implements PatientApi {

    private final PatientService patientService;

    @Autowired
    public PatientControlleur(PatientService patientService) {
        this.patientService = patientService;
    }

    @Override
    public PatientDto save(PatientDto patientDto) {
        return patientService.save(patientDto);
    }

    @Override
    public PatientDto findById(Long id) {
        return patientService.findById(id);
    }

    @Override
    public PatientDto findByNom(String nom) {
        return patientService.findByNom(nom);
    }

    @Override
    public List<PatientDto> findAll() {
        return patientService.findAll();
    }

    @Override
    public PatientDto update(Long id, PatientDto patientDto) {
        return patientService.update(id,patientDto);
    }

    @Override
    public void delete(Long id) {
        patientService.delete(id);
    }
}
