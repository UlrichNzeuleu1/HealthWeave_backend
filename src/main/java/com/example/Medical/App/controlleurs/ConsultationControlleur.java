package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.ConsultationApi;
import com.example.Medical.App.dto.ConsultationDto;
import com.example.Medical.App.services.interfaces.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsultationControlleur implements ConsultationApi {

    private final ConsultationService consultationService;

    @Autowired
    public ConsultationControlleur(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }


    @Override
    public ConsultationDto save(ConsultationDto consultationDto) {
        return consultationService.save(consultationDto);
    }

    @Override
    public ConsultationDto findById(Long id) {
        return consultationService.findById(id);
    }

    @Override
    public List<ConsultationDto> findAll() {
        return consultationService.findAll();
    }

    @Override
    public ConsultationDto findByTypeConsultation(String typeConsultation) {
        return consultationService.findByType(typeConsultation);
    }

    /*@Override
    public ConsultationDto findByType(String type) {
        return consultationService.findByType(type);
    }*/

    @Override
    public ConsultationDto update(Long id, ConsultationDto consultationDto) {
        return consultationService.update(id,consultationDto);
    }

    @Override
    public void delete(Long id) {
        consultationService.delete(id);
    }
}
