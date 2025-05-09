package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.HopitalDto;
import com.example.Medical.App.dto.MedecinDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/medecins")
public interface MedecinApi {

    @PostMapping(value = APP_ROOT + "/medecins/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MedecinDto save (@RequestBody MedecinDto medecinDto);

    @GetMapping(value = APP_ROOT + "/medecins/{idMedecin}/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    MedecinDto findById (@PathVariable("idMedecin") Long id);

    @GetMapping(value = APP_ROOT + "/medecins/{nomMedecin}/getByNom", produces = MediaType.APPLICATION_JSON_VALUE)
    MedecinDto findByNom (@PathVariable("nomMedecin") String nom);

    @GetMapping(value = APP_ROOT + "/medecins/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MedecinDto> findAll ();

    @PutMapping(value = APP_ROOT + "/medecins/{idMedecin}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MedecinDto update (@PathVariable("idMedecin") Long id, @RequestBody MedecinDto medecinDto);

    @DeleteMapping(value = APP_ROOT + "/medecins/delete/{idMedecin}")
    void delete (@PathVariable("idMedecin") Long id);
}
