package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.CompteDto;
import com.example.Medical.App.dto.ConsultationDto;

import java.util.List;

public interface ConsultationService {

    ConsultationDto save (ConsultationDto consultationDto);
    ConsultationDto findById (Long id);
    List<ConsultationDto> findAll ();
    ConsultationDto findByType(String type);
    ConsultationDto update (Long id, ConsultationDto consultationDto);
    void delete (Long id);
}
