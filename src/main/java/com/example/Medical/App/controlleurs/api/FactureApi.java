package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.AssuranceDto;
import com.example.Medical.App.dto.FactureDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/factures")
public interface FactureApi {

    @PostMapping(value = APP_ROOT + "/factures/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FactureDto save (@RequestBody FactureDto factureDto);

    @GetMapping(value = APP_ROOT + "/factures/{idFacture}", produces = MediaType.APPLICATION_JSON_VALUE)
    FactureDto findById (@PathVariable("idFacture") Long id);

    @GetMapping(value = APP_ROOT + "/factures/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FactureDto> findAll ();

    @PutMapping(value = APP_ROOT + "/factures/{idFacture}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    FactureDto update (@PathVariable("idFacture") Long id, @RequestBody FactureDto factureDto);

    @DeleteMapping(value = APP_ROOT + "/factures/delete/{idFacture}")
    void delete (@PathVariable("idFacture") Long id);
}
