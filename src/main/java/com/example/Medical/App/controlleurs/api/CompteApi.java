package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.AssuranceDto;
import com.example.Medical.App.dto.CompteDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/comptes")
public interface CompteApi {

    @PostMapping(value = APP_ROOT + "/comptes/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CompteDto save (@RequestBody CompteDto compteDto);

    @GetMapping(value = APP_ROOT + "/comptes/{idCompte}", produces = MediaType.APPLICATION_JSON_VALUE)
    CompteDto findById (@PathVariable("idCompte") Long id);

    @GetMapping(value = APP_ROOT + "/comptes/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CompteDto> findAll ();

    @GetMapping(value = APP_ROOT + "/comptes/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    CompteDto findByEmail(@PathVariable("email") String email);

    @PutMapping(value = APP_ROOT + "/comptes/{idCompte}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CompteDto update (@PathVariable("idCompte") Long id, @RequestBody CompteDto compteDto);

    @DeleteMapping(value = APP_ROOT + "/comptes/delete/{idCompte}")
    void delete (@PathVariable("idCompte") Long id);
}
