package com.example.Medical.App.dto;

import com.example.Medical.App.models.Utilisateur;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UtilisateurDto {

    private Long id;
    private String nom;
    private String prenom;
    private String typeUtilisateur;
    private String email;
    private String motDePasse;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur){
        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .typeUtilisateur(utilisateur.getTypeUtilisateur())
                .email(utilisateur.getEmail())
                .motDePasse(utilisateur.getMotDePasse())
                .build();
    }
    public static Utilisateur toEntity(UtilisateurDto dto){
        return Utilisateur.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .typeUtilisateur(dto.getTypeUtilisateur())
                .email(dto.getEmail())
                .motDePasse((dto.getMotDePasse()))
                .build();
    }
}
