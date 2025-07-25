package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.AssuranceDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/assurances")
public interface AssuranceApi {

    @PostMapping(value = APP_ROOT + "/assurances/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AssuranceDto save (@RequestBody AssuranceDto assuranceDto);

    @GetMapping(value = APP_ROOT + "/assurances/{idAssurance}/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    AssuranceDto findById (@PathVariable("idAssurance") Long id);

    @GetMapping(value = APP_ROOT + "/assurances/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AssuranceDto> findAll ();

    @GetMapping(value = APP_ROOT + "/assurances/{nom}/getByNom", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<AssuranceDto>> findByNom(@PathVariable String nom);

    @PutMapping(value = APP_ROOT + "/assurances/{idAssurance}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AssuranceDto update (@PathVariable("idAssurance") Long id, @RequestBody AssuranceDto assuranceDto);

    @DeleteMapping(value = APP_ROOT + "/assurances/{idAssurance}")
    void delete (@PathVariable("idAssurance") Long id);
}
