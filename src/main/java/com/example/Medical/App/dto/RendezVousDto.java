package com.example.Medical.App.dto;

import com.example.Medical.App.models.RendezVous;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.swing.text.html.parser.Entity;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RendezVousDto {

    private Long id;
    private Date dateRendezVous;
    private String heure;
    private String statut;

    public static RendezVousDto fromEntity(RendezVous rendezVous){
        return RendezVousDto.builder()
                .id(rendezVous.getId())
                .heure(rendezVous.getHeure())
                .statut(rendezVous.getStatut())
                .dateRendezVous(rendezVous.getDateRendezVous())
                .build();
    }
    public static RendezVous toEntity(RendezVousDto dto){
        return RendezVous.builder()
                .id(dto.getId())
                .dateRendezVous(dto.getDateRendezVous())
                .statut(dto.getStatut())
                .heure(dto.getHeure())
                .build();
    }
}
