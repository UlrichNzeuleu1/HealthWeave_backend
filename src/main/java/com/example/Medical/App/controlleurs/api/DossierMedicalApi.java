package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.ConsultationDto;
import com.example.Medical.App.dto.DossierMedicalDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/dossierMedicals")
public interface DossierMedicalApi {

    @PostMapping(value = APP_ROOT + "/dossierMedicals/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DossierMedicalDto save (@RequestBody DossierMedicalDto dossierMedicalDto);

    @GetMapping(value = APP_ROOT + "/dossierMedicals/{idDossierMedical}", produces = MediaType.APPLICATION_JSON_VALUE)
    DossierMedicalDto findById (@PathVariable("idDossierMedical") Long id);

    @GetMapping(value = APP_ROOT + "/dossierMedicals/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<DossierMedicalDto> findAll ();

    @PutMapping(value = APP_ROOT + "/dossierMedicals/{idDossierMedical}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DossierMedicalDto update (@PathVariable("idDossierMedical") Long id, @RequestBody DossierMedicalDto dossierMedicalDto);

    @DeleteMapping(value = APP_ROOT + "/dossierMedicals/delete/{idDossierMedical}")
    void delete (@PathVariable("idDossierMedical") Long id);
}
