package com.example.Medical.App.dto;

import com.example.Medical.App.models.Consultation;
import com.example.Medical.App.models.RendezVous;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDto{

    private Long id;
    private String type;
    private LocalDateTime date;
    private String heure;
    private String statut;




    // Mapping from Entity ---->> to Dto

    public static ConsultationDto fromEntity(Consultation consultation){
        return ConsultationDto.builder()
                .id(consultation.getId())
                .date(consultation.getDate())
                .type(consultation.getType())
                .heure(consultation.getHeure())
                .statut(consultation.getStatut())
                .build();
    }

    // Mapping from Dto ----> to Entity

    public static Consultation toEntity(ConsultationDto dto){
        return Consultation.builder()
                .id(dto.getId())
                .date(dto.getDate())
                .type(dto.getType())
                .heure(dto.getHeure())
                .statut(dto.getStatut())
                .build();
    }


}
