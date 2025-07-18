package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.ConsultationDto;

import java.util.List;
import java.util.Optional;

public interface ConsultationService {

    ConsultationDto save (ConsultationDto consultationDto);
    ConsultationDto findById (Long id);
    List<ConsultationDto> findAll ();
    List<ConsultationDto> findByType(String type);
    List<ConsultationDto> findByTypeAndStatut(String type, String statut);
    ConsultationDto update (Long id, ConsultationDto consultationDto);
    void delete (Long id);
}
