package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.HopitalDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/hopitals")
public interface HopitalApi {

    @PostMapping(value = APP_ROOT + "/hopitals/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    HopitalDto save (@RequestBody HopitalDto hopitalDto);

    @GetMapping(value = APP_ROOT + "/hopitals/{idHopital}/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    HopitalDto findById (@PathVariable("idHopital") Long id);

    @GetMapping(value = APP_ROOT + "/hopitals/{nomHopital}/getByNom", produces = MediaType.APPLICATION_JSON_VALUE)
    List<HopitalDto> findByNom (@PathVariable("nomHopital") String nom);

    @GetMapping(value = APP_ROOT + "/hopitals/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<HopitalDto> findAll ();

    @PutMapping(value = APP_ROOT + "/hopitals/{idHopital}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    HopitalDto update (@PathVariable("idHopital") Long id, @RequestBody HopitalDto hopitalDto);

    @DeleteMapping(value = APP_ROOT + "/hopitals/delete/{idHopital}")
    void delete (@PathVariable("idHopital") Long id);
}
