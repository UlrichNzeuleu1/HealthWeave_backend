package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.AssuranceDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/assurances")
public interface AssuranceApi {

    @PostMapping(value = APP_ROOT + "/assurances/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AssuranceDto save (@RequestBody AssuranceDto assuranceDto);

    @GetMapping(value = APP_ROOT + "/assurances/{idAssurance}", produces = MediaType.APPLICATION_JSON_VALUE)
    AssuranceDto findById (@PathVariable("idAssurance") Long id);

    @GetMapping(value = APP_ROOT + "/assurances/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AssuranceDto> findAll ();

    @GetMapping(value = APP_ROOT + "/assurances/{nomAssureur}", produces = MediaType.APPLICATION_JSON_VALUE)
    AssuranceDto findByNomAssureur(@PathVariable("nomAssureur") String nomAssureur);

    @PutMapping(value = APP_ROOT + "/assurances/{idAssurance}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AssuranceDto update (@PathVariable("idAssurance") Long id, @RequestBody AssuranceDto assuranceDto);

    @DeleteMapping(value = APP_ROOT + "/assurances/delete/{idAssurance}")
    void delete (@PathVariable("idAssurance") Long id);
}
