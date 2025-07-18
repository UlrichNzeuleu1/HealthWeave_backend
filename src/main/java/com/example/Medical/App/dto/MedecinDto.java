package com.example.Medical.App.dto;

import com.example.Medical.App.models.Adresse;
import com.example.Medical.App.models.Medecin;
import com.example.Medical.App.models.RendezVous;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class MedecinDto {

    private Long id;
    private String specialite;
    private String nom;
    private String prenom;
    private String sexe;
    private LocalDate dateDeNaissance;
    private String email;

    public static MedecinDto fromEntity(Medecin medecin){
        return MedecinDto.builder()

                .specialite(medecin.getSpecialite())
                .nom(medecin.getNom())
                .prenom(medecin.getPrenom())
                .sexe(medecin.getSexe())
                .email(medecin.getEmail())
                .dateDeNaissance(medecin.getDateDeNaissance())
                .build();
    }

    public static Medecin toEntity(MedecinDto dto){
        return Medecin.builder()
                .specialite(dto.getSpecialite())
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .sexe(dto.getSexe())
                .dateDeNaissance(dto.getDateDeNaissance())
                .email(dto.getEmail())
                .build();
    }
}
