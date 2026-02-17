package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.FactureDto;
import com.example.Medical.App.dto.RendezVousDto;
import com.example.Medical.App.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT+ "/utilisateurs")
public interface UtilisateurApi {

    @PostMapping(value = APP_ROOT + "/utilisateurs/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto save (@RequestBody UtilisateurDto utilisateurDto);

    @GetMapping(value = APP_ROOT + "/utilisateurs/{idUtilisateur}/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto findById (@PathVariable("idUtilisateur") Long id);

    @GetMapping(value = APP_ROOT + "/utilisateurs/{nomUtilisateur}/getByNom", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findByNom (@PathVariable("nomUtilisateur") String nom);

    @GetMapping(value = APP_ROOT + "/utilisateurs/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDto> findAll ();

    @PutMapping(value = APP_ROOT + "/utilisateurs/{idUtilisateur}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDto update (@PathVariable("idUtilisateur") Long id, @RequestBody UtilisateurDto utilisateurDto);

    @DeleteMapping(value = APP_ROOT + "/utilisateurs/delete/{idUtilisateur}")
    void delete (@PathVariable("idUtilisateur") Long id);
}
