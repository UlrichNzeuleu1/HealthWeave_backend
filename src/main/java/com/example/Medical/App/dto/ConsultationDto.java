package com.example.Medical.App.dto;

import com.example.Medical.App.models.Consultation;
import com.example.Medical.App.models.RendezVous;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ConsultationDto{

    private Long id;
    private String typeConsultation;
    private Date dateConsultation;
    private String Heure;
    private String statut;


    // Mapping from Entity ---->> to Dto
    public static ConsultationDto fromEntity(Consultation consultation){
        return ConsultationDto.builder()
                .id(consultation.getId())
                .dateConsultation(consultation.getDateConsultation())
                .typeConsultation(consultation.getTypeConsultation())
                .Heure(consultation.getHeure())
                .statut(consultation.getStatut())
                .build();
    }

    // Mapping from Dto ----> to Entity

    public static Consultation toEntity(ConsultationDto dto){
        return Consultation.builder()
                .id(dto.getId())
                .dateConsultation(dto.getDateConsultation())
                .typeConsultation(dto.getTypeConsultation())
                .Heure(dto.getHeure())
                .statut(dto.getStatut())
                .build();
    }
}
