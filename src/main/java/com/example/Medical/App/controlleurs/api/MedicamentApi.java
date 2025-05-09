package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.MedecinDto;
import com.example.Medical.App.dto.MedicamentDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/medicaments")
public interface MedicamentApi {

    @PostMapping(value = APP_ROOT + "/medicaments/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MedicamentDto save (@RequestBody MedicamentDto medicamentDto);

    @GetMapping(value = APP_ROOT + "/medicaments/{idMedicament}/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    MedicamentDto findById (@PathVariable("idMedicament") Long id);

    @GetMapping(value = APP_ROOT + "/medicaments/{nomMedicament}/getByNom", produces = MediaType.APPLICATION_JSON_VALUE)
    MedicamentDto findByNom (@PathVariable("nomMedicament") String nom);

    @GetMapping(value = APP_ROOT + "/medicaments/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<MedicamentDto> findAll ();

    @PutMapping(value = APP_ROOT + "/medicaments/{idMedicament}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    MedicamentDto update (@PathVariable("idMedicament") Long id, @RequestBody MedicamentDto medicamentDto);

    @DeleteMapping(value = APP_ROOT + "/medicaments/delete/{idMedicament}")
    void delete (@PathVariable("idMedicament") Long id);
}
