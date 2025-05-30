package com.example.Medical.App.dto;

import com.example.Medical.App.models.RendezVous;
import lombok.*;

import javax.swing.text.html.parser.Entity;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RendezVousDto {

    private Long id;
    private LocalDate dateRendezVous;
    private String heure;
    private String statut;
    private String medecinSouhaite;
    private String nomPatient;
    private String prenomPatient;


    public static RendezVousDto fromEntity(RendezVous rendezVous){
        return RendezVousDto.builder()
                .id(rendezVous.getId())
                .heure(rendezVous.getHeure())
                .statut(rendezVous.getStatut())
                .medecinSouhaite(rendezVous.getMedecinSouhaite())
                .dateRendezVous(rendezVous.getDateRendezVous())
                .nomPatient(rendezVous.getNomPatient())
                .prenomPatient(rendezVous.getPrenomPatient())
                .build();
    }
    public static RendezVous toEntity(RendezVousDto dto){
        return RendezVous.builder()
                .id(dto.getId())
                .dateRendezVous(dto.getDateRendezVous())
                .statut(dto.getStatut())
                .heure(dto.getHeure())
                .medecinSouhaite(dto.getMedecinSouhaite())
                .nomPatient(dto.getNomPatient())
                .prenomPatient(dto.getPrenomPatient())
                .build();
    }
}
