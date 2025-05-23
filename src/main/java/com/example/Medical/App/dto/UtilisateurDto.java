package com.example.Medical.App.dto;

import com.example.Medical.App.models.Utilisateur;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UtilisateurDto {

    private Long id;
    private String nom;
    private String prenom;
    private String sexe;
    private LocalDate dateDeNaissance;
    private String typeUtilisateur;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .sexe(utilisateur.getSexe())
                .prenom(utilisateur.getPrenom())
                .typeUtilisateur(utilisateur.getTypeUtilisateur())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .build();
    }
    public static Utilisateur toEntity(UtilisateurDto dto){
        return Utilisateur.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .sexe(dto.getSexe())
                .prenom(dto.getPrenom())
                .dateDeNaissance(dto.getDateDeNaissance())
                .typeUtilisateur(dto.getTypeUtilisateur())
                .build();
    }
}
