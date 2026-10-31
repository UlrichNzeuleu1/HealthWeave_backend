package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.PatientApi;
import com.example.Medical.App.dto.PatientDto;
import com.example.Medical.App.services.interfaces.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PatientControlleur implements PatientApi {

    private final PatientService patientService;

    @Autowired
    public PatientControlleur(PatientService patientService) {
        this.patientService = patientService;
    }

    /*@Override
    public PatientDto save(PatientDto patientDto) { return patientService.save(patientDto);}


    @Override
    public PatientDto save(@RequestBody PatientDto patientDto){
        return patientService.save(patientDto);
    }*/
    /*
    @Override
    public ResponseEntity<PatientDto> save(@RequestPart("patientDto") PatientDto patientDto, @RequestPart(value = "file", required = false) MultipartFile file){

        PatientDto savedPatientDto = patientService.savePatientWithPhoto(patientDto,file);
        return new ResponseEntity<>(savedPatientDto, HttpStatus.CREATED);
    }*/
    @Override
    public ResponseEntity<PatientDto> save(String patientDtoJson, MultipartFile file) {
        PatientDto patientDto = null;
        try {
            // Conversion de la chaîne JSON en objet PatientDto
            ObjectMapper objectMapper = new ObjectMapper();
            patientDto = objectMapper.readValue(patientDtoJson, PatientDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la conversion du JSON patient", e);
        }

        PatientDto savedPatientDto = patientService.savePatientWithPhoto(patientDto, file);
        return new ResponseEntity<>(savedPatientDto, HttpStatus.CREATED);
    }


    @Override
    public PatientDto findById(Long id) {
        return patientService.findById(id);
    }

    @Override
    public List<PatientDto> findByNom(String nom) {
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
