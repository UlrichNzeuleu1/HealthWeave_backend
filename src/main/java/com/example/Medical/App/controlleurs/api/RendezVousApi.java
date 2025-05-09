package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.PatientDto;
import com.example.Medical.App.dto.RendezVousDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;
@Api(APP_ROOT + "/rendezVous")
public interface RendezVousApi {

    @PostMapping(value = APP_ROOT + "/rendezVous/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RendezVousDto save (@RequestBody RendezVousDto rendezVousDto);

    @GetMapping(value = APP_ROOT + "/rendezVous/{idPatient}/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    RendezVousDto findById (@PathVariable("idPatient") Long id);

    @GetMapping(value = APP_ROOT + "/rendezVous/{statutRendezVous}/getAllByStatut", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RendezVousDto> findAllByStatut (@PathVariable("statutRendezVous") String status);

    @GetMapping(value = APP_ROOT + "/rendezVous/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<RendezVousDto> findAll ();

    @PutMapping(value = APP_ROOT + "/rendezVous/{idRendezVous}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    RendezVousDto update (@PathVariable("idRendezVous") Long id, @RequestBody RendezVousDto rendezVousDto);

    @DeleteMapping(value = APP_ROOT + "/rendezVous/delete/{idRendezVous}")
    void delete (@PathVariable("idRendezVous") Long id);
}
