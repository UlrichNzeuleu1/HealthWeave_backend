package com.example.Medical.App.controlleurs.api;


import com.example.Medical.App.dto.AdresseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/adresses")
public interface AdresseApi {


    @PostMapping(value = APP_ROOT + "/adresses/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer une adresse", notes = "cette methode permet d'enregistrer ou de modifier une adresse", response = AdresseDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet adresse cree / modifier"),
            @ApiResponse(code = 400, message = "L'objet adresse n'est pas valide")
    })
    AdresseDto save(@RequestBody AdresseDto dto);               //@RequestBody: c'est pour la deserialisation c-a-d la transformation d'un text du format json vers cette objet de type ArticleDto

    @GetMapping(value = APP_ROOT + "/adresses/{idAdresse}", produces = MediaType.APPLICATION_JSON_VALUE)
    AdresseDto findById(@PathVariable("idAdresse") Long id);

    @GetMapping(value = APP_ROOT + "/adresses/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<AdresseDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/adresses/{idAdresse}")
    void delete(@PathVariable("idAdresse") Long id);

    @PutMapping(value = APP_ROOT + "/adresses/{idAdresse}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    AdresseDto update(@PathVariable("idAdresse") Long id, @RequestBody AdresseDto dto);
}
