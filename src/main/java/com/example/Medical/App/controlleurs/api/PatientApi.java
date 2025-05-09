package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.MedicamentDto;
import com.example.Medical.App.dto.PatientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/patients")
public interface PatientApi {

    @PostMapping(value = APP_ROOT + "/patients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PatientDto save (@RequestBody PatientDto patientDto);

    @GetMapping(value = APP_ROOT + "/patients/{idPatient}/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    PatientDto findById (@PathVariable("idPatient") Long id);

    @GetMapping(value = APP_ROOT + "/patients/{nomPatient}/getByNom", produces = MediaType.APPLICATION_JSON_VALUE)
    PatientDto findByNom (@PathVariable("nomPatient") String nom);

    @GetMapping(value = APP_ROOT + "/patients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PatientDto> findAll ();

    @PutMapping(value = APP_ROOT + "/patients/{idPatient}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PatientDto update (@PathVariable("idPatient") Long id, @RequestBody PatientDto patientDto);

    @DeleteMapping(value = APP_ROOT + "/patients/delete/{idPatient}")
    void delete (@PathVariable("idPatient") Long id);
}
