package com.example.Medical.App.controlleurs.api;

import com.example.Medical.App.dto.CompteDto;
import com.example.Medical.App.dto.ConsultationDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Medical.App.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/consultations")

public interface ConsultationApi {

    @PostMapping(value = APP_ROOT + "/consultations/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ConsultationDto save (@RequestBody ConsultationDto consultationDto);

    @GetMapping(value = APP_ROOT + "/consultations/{idConsultation}/getById", produces = MediaType.APPLICATION_JSON_VALUE)
    ConsultationDto findById (@PathVariable("idConsultation") Long id);

    @GetMapping(value = APP_ROOT + "/consultations/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ConsultationDto> findAll ();

    @GetMapping(value = APP_ROOT + "/consultations/{typeConsultation}/getByType", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ConsultationDto> findByType(@PathVariable("typeConsultation") String type);

    @GetMapping(value = APP_ROOT + "/consultations/{type}/getByTypeAndStatut", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ConsultationDto> findByTypeAndStatut(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String statut
    );

    @PutMapping(value = APP_ROOT + "/consultations/{idConsultation}/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ConsultationDto update (@PathVariable("idConsultation") Long id, @RequestBody ConsultationDto consultationDto);

    @DeleteMapping(value = APP_ROOT + "/consultations/delete/{idConsultation}")
    void delete (@PathVariable("idConsultation") Long id);
}
