package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.PatientDto;
import com.example.Medical.App.dto.PersonnelAdministratifDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/personnelAdministratifs")
public interface PersonnelAdministratifApi {

    @PostMapping(value = APP_ROOT + "/personnelAdministratifs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PersonnelAdministratifDto save (@RequestBody PersonnelAdministratifDto dto);

    @GetMapping(value = APP_ROOT + "/personnelAdministratifs/{idPersonnel}/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    PersonnelAdministratifDto findById (@PathVariable("idPersonnel") Long id);

    @GetMapping(value = APP_ROOT + "/personnelAdministratifs/{nomPersonnel}/getByNom", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PersonnelAdministratifDto> findByNom (@PathVariable("nomPersonnel") String nom);

    @GetMapping(value = APP_ROOT + "/personnelAdministratifs/{role}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PersonnelAdministratifDto> findByRole (@PathVariable("role") String role);

    @GetMapping(value = APP_ROOT + "/personnelAdministratifs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<PersonnelAdministratifDto> findAll ();

    @PutMapping(value = APP_ROOT + "/personnelAdministratifs/{idPersonnel}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    PersonnelAdministratifDto update (@PathVariable("idPersonnel") Long id, @RequestBody PersonnelAdministratifDto dto);

    @DeleteMapping(value = APP_ROOT + "/personnelAdministratifs/delete/{idPersonnel}")
    void delete (@PathVariable("idPersonnel") Long id);
}
